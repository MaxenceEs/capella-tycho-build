package capella.up.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;

import capella.up.console.ConsoleDisplayer;

public class ConsoleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event){
		ConsoleDisplayer.open();
		return null;
	}
}
