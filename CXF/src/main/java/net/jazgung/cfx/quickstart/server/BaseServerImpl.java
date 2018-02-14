package net.jazgung.cfx.quickstart.server;

public abstract class BaseServerImpl implements Server {

	@Override
	public void shutdown() {
		System.out.println("shutdown");
	}
}
