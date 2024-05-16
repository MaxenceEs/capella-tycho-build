package capella.up.console;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.PlatformUI;

public class Console extends OutputStream {

	public static Console INSTANCE;

	private Console() {
	}

	private static Font FONT_GROUP = new Font(Display.getCurrent(), "Arial", 12, SWT.BOLD | SWT.ITALIC);
	private StyledText styledText;

	public static void createNewInstance() {
		INSTANCE = new Console();
		INSTANCE.createGui();
	}

	private void createGui() {
		Group group = new Group(ConsoleDisplayer.SHELL, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		group.setLayout(new GridLayout(1, false));
		group.setText("Console");
		group.setFont(FONT_GROUP);
		this.styledText = new StyledText(group, SWT.V_SCROLL | SWT.H_SCROLL);
		this.styledText.setEditable(false);
		this.styledText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		initConsole();

	}

	private void initConsole() {
		initializePrintStream();
		String version = "1.0.0";
		this.styledText.append("Welcome to Capella UP v" + version);
	}

	public void initializePrintStream() {
		PrintStream ps = new PrintStream(this);
		System.setOut(ps);
		System.setErr(ps);
	}

	@Override
	public void write(int b) throws IOException {
		write(new byte[] { (byte) b }, 0, 1);
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException{
		final String message = new String(b, off, len);
		PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
			if (styledText !=null && !styledText.isDisposed()) {
				styledText.append(message);
			}
		});
	}
}
