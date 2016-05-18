package controller;

public interface Command {
	public void doCommand();
	public void setArgs(String[] args);
}
