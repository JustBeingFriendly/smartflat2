package smartflat2;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Text;

public class TenantCheckPay {

	protected Shell shell;
	private Table table;
	private Text text;
	private Text namesTextArea;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TenantCheckPay window = new TenantCheckPay();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault(); 
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1152, 690);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.NONE);
		mntmFile.setText("File");
		
		Composite pnl1 = new Composite(shell, SWT.NONE);
		pnl1.setBounds(0, 0, 1136, 621);
		
		table = new Table(pnl1, SWT.FULL_SELECTION);
		table.setBounds(541, 27, 564, 289);
		table.setHeaderVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(181);
		tblclmnNewColumn.setText("Name");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Property");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(66);
		tblclmnNewColumn_2.setText("Unit");
		
		TableColumn tblclmnPhone = new TableColumn(table, SWT.NONE);
		tblclmnPhone.setWidth(100);
		tblclmnPhone.setText("Phone");
		
		TableColumn tblclmnAmount = new TableColumn(table, SWT.NONE);
		tblclmnAmount.setWidth(100);
		tblclmnAmount.setText("Amount");
		
		Button btnCreateTables = new Button(pnl1, SWT.NONE);
		btnCreateTables.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				CreateTables ct = new CreateTables();
				String s = ct.createTables();
				text.setText(s);
			}
		});
		btnCreateTables.setBounds(116, 40, 75, 25);
		btnCreateTables.setText("Create Tables");
		
		text = new Text(pnl1, SWT.BORDER | SWT.MULTI);
		text.setBounds(299, 29, 236, 220);
		
		Button btnShowNames = new Button(pnl1, SWT.NONE);
		btnShowNames.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//Read csv to array
				OccupantNameReader onr = new OccupantNameReader();
				String[][] names = onr.readFile();
				//Display array contents in text area
				namesTextArea.setText("");
				for(int i = 0; i < names.length; i++){
					namesTextArea.append(names[i][0].toString() + " " + names[i][1].toString() + "\n");
				}
				//Display array contents in table
				Display display = Display.getCurrent();
				Color grey = display.getSystemColor(SWT.COLOR_GRAY);
				TableItem[] items = new TableItem[names.length];
				for (int i = 0; i < items.length; i++){
					String[] tableEntry = {names[i][0].toString() + " " + names[i][1].toString(), "0", "0" ,"0", "0"};
					items[i] = new TableItem(table, SWT.NONE);
					items[i].setText(tableEntry);
					//Add grey colour to alternating rows 
					if ((i % 2) == 0){
						items[i].setBackground(grey);
					}
				}
			}
		});
		btnShowNames.setText("Show Me The Names");
		btnShowNames.setBounds(78, 306, 141, 25);
		
		namesTextArea = new Text(pnl1, SWT.BORDER | SWT.MULTI);
		namesTextArea.setBounds(299, 295, 236, 220);

	}
}
