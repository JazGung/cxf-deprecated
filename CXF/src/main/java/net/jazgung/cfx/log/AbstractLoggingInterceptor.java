/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package net.jazgung.cfx.log;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URI;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.log4j.Logger;

/**
 * A simple logging handler which outputs the bytes of the message to the
 * Logger.
 */
public abstract class AbstractLoggingInterceptor extends AbstractPhaseInterceptor<Message> {

	static Logger log = Logger.getLogger(AbstractLoggingInterceptor.class);

	protected int limit = 100 * 1024;
	protected PrintWriter writer;
	protected boolean prettyLogging;

	public AbstractLoggingInterceptor(String phase) {
		super(phase);
	}

	public void setOutputLocation(String s) {
		if (s == null || "<logger>".equals(s)) {
			writer = null;
		} else if ("<stdout>".equals(s)) {
			writer = new PrintWriter(System.out, true);
		} else if ("<stderr>".equals(s)) {
			writer = new PrintWriter(System.err, true);
		} else {
			try {
				URI uri = new URI(s);
				File file = new File(uri);
				writer = new PrintWriter(new FileWriter(file, true), true);
			} catch (Exception ex) {
				log.warn("Error configuring log location " + s, ex);
			}
		}
	}

	public void setPrintWriter(PrintWriter w) {
		writer = w;
	}

	public PrintWriter getPrintWriter() {
		return writer;
	}

	public void setLimit(int lim) {
		limit = lim;
	}

	public int getLimit() {
		return limit;
	}

	public void setPrettyLogging(boolean flag) {
		prettyLogging = flag;
	}

	public boolean isPrettyLogging() {
		return prettyLogging;
	}

	protected void writePayload(StringBuilder builder, CachedOutputStream cos, String encoding, String contentType) throws Exception {
		// Just transform the XML message
		if (StringUtils.isEmpty(encoding)) {
			cos.writeCacheTo(builder, limit);
		} else {
			cos.writeCacheTo(builder, encoding, limit);
		}
	}

	/**
	 * Transform the string before display. The implementation in this class does
	 * nothing. Override this method if you want to change the contents of the
	 * logged message before it is delivered to the output. For example, you can use
	 * this to mask out sensitive information.
	 * 
	 * @param originalLogString
	 *            the raw log message.
	 * @return transformed data
	 */
	protected String transform(String originalLogString) {
		return originalLogString;
	}

	protected void log(String message) {
		message = transform(message);
		if (writer != null) {
			writer.println(message);
		} else if (log.isInfoEnabled()) {
			log.info(message);
		}
	}

}
