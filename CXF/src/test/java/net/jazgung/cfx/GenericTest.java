package net.jazgung.cfx;

import net.jazgung.cfx.log.Logger;

public abstract class GenericTest {

	protected void printCutOffRule() {
		printCutOffRule("");
	}

	protected void printCutOffRule(String message) {
		Logger.log(message);
	}

}
