package max.capella.console.displayer.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;

import max.capella.console.displayer.console.ConsoleDisplayer;

public class ConsoleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event){
		ConsoleDisplayer.open();
		return null;
	}
}
