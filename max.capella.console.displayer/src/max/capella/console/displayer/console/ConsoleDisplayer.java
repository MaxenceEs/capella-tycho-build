package max.capella.console.displayer.console;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class ConsoleDisplayer {
public static Shell SHELL;
public static void open() {
	if (SHELL == null || SHELL.isDisposed()) {
		SHELL = new Shell(PlatformUI.getWorkbench().getDisplay(), SWT.SHELL_TRIM);
		Console.createNewInstance();
		SHELL.setText("GUI Console Displayer");
		SHELL.setLayout(new GridLayout(1, false));
		SHELL.pack();
		SHELL.open();
		SHELL.setMinimumSize(1400,700);
	}
}
public static void close() {
	if (SHELL != null && !SHELL.isDisposed()) {
		SHELL.dispose();
	}
}
}
