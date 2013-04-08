import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.util.ArrayList;
import java.util.Date;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Spinner;
import blog.Author;
import blog.Blogg;
import blog.Category;
import blog.Post;

public class MainWindow {

	protected Shell shell;
	private Text text;
	private List list;
	private String gender;
	private java.util.List<Author> authors = new ArrayList<Author>();
	private java.util.List<Category> categories = new ArrayList<Category>();
	
	Author author;
	Category category;
	Post post;
	Blogg bloggs;
	Date date = new Date();
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Spinner text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
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
		shell.setSize(633, 552);
		shell.setText("SWT Application");

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 229, 315);

		// textbox
		text = new Text(composite, SWT.BORDER);
		text.setBounds(83, 43, 137, 18);

		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(10, 155, 209, 126);

		Label lblSkapaNyttInlgg = new Label(composite, SWT.NONE);
		lblSkapaNyttInlgg.setBounds(72, 10, 97, 15);
		lblSkapaNyttInlgg.setText("Skapa nytt inl\u00E4gg");

		Label lblTitle = new Label(composite, SWT.NONE);
		lblTitle.setBounds(10, 46, 55, 15);
		lblTitle.setText("Title:");

		Label lblFrfattare = new Label(composite, SWT.NONE);
		lblFrfattare.setBounds(10, 71, 65, 15);
		lblFrfattare.setText("F\u00F6rfattare:");

		Label lblInnehll = new Label(composite, SWT.NONE);
		lblInnehll.setBounds(10, 134, 65, 15);
		lblInnehll.setText("Inneh\u00E5ll:");

		Label lblDatum = new Label(composite, SWT.NONE);
		lblDatum.setText("Datum:");
		lblDatum.setBounds(10, 113, 65, 15);

		Label lblKategori = new Label(composite, SWT.NONE);
		lblKategori.setText("Kategori:");
		lblKategori.setBounds(10, 92, 65, 15);

		DateTime dateTime = new DateTime(composite, SWT.BORDER);
		dateTime.setBounds(83, 113, 80, 18);

		final CCombo combo = new CCombo(composite, SWT.BORDER);
		combo.setEditable(false);
		combo.setBounds(83, 67, 137, 18);

		final CCombo combo_1 = new CCombo(composite, SWT.BORDER);
		combo_1.setEditable(false);
		combo_1.setBounds(83, 89, 137, 18);

		Button btnSkapaBlogginlgg = new Button(composite, SWT.NONE);
		btnSkapaBlogginlgg.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String title = text.getText();
				String content = text_1.getText();
				
				int authorIndex = combo.getSelectionIndex();
				int categoryIndex = combo_1.getSelectionIndex();
				author = authors.get(authorIndex);
				category = categories.get(categoryIndex);
				
				post = new Post();
				post.SetValues(title, content, date, author, category); ////////
				//bloggs.AddToList(post);
				list.add(post.getTitle());
				
				text.setText("");
				text_1.setText("");
				combo.select(-1);
				combo_1.select(-1);
				
				//funkar inte att lägga till i bloggs
				//nollställa datum
				// ändra set och get i Post för att förmedla author
				// hur får man date
				// hur får jag hela author till posten????  kolla så inte null!!!
				// kunna uppdatera författare, kategori och själva inlägget
			}
		});
		btnSkapaBlogginlgg.setText("Posta blogginl\u00E4gg");
		btnSkapaBlogginlgg.setBounds(10, 287, 108, 21);

		Composite composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setBounds(229, 0, 304, 161);

		Label lblSkapaNyFrfattare = new Label(composite_1, SWT.NONE);
		lblSkapaNyFrfattare.setText("Skapa ny f\u00F6rfattare");
		lblSkapaNyFrfattare.setBounds(105, 10, 106, 15);

		Label lblNamn = new Label(composite_1, SWT.NONE);
		lblNamn.setText("F\u00F6rnamn:");
		lblNamn.setBounds(10, 31, 57, 15);

		Label lblEfternamn = new Label(composite_1, SWT.NONE);
		lblEfternamn.setText("Efternamn:");
		lblEfternamn.setBounds(10, 52, 63, 15);

		Label lblUrsprungsland = new Label(composite_1, SWT.NONE);
		lblUrsprungsland.setText("Ursprungsland:");
		lblUrsprungsland.setBounds(10, 94, 80, 15);

		Label lbllder = new Label(composite_1, SWT.NONE);
		lbllder.setText("\u00C5lder:");
		lbllder.setBounds(10, 73, 57, 15);

		Label lblEmail = new Label(composite_1, SWT.NONE);
		lblEmail.setText("Email:");
		lblEmail.setBounds(10, 113, 57, 15);

		text_2 = new Text(composite_1, SWT.BORDER);
		text_2.setBounds(96, 28, 165, 18);

		text_3 = new Text(composite_1, SWT.BORDER);
		text_3.setBounds(96, 49, 165, 18);

		text_4 = new Spinner(composite_1, SWT.BORDER);
		text_4.setBounds(96, 70, 45, 18);

		text_5 = new Text(composite_1, SWT.BORDER);
		text_5.setBounds(96, 91, 165, 18);

		text_6 = new Text(composite_1, SWT.BORDER);
		text_6.setBounds(96, 110, 165, 18);

		final Button btnMan = new Button(composite_1, SWT.RADIO);
		btnMan.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				gender = "Male";

			}
		});
		btnMan.setBounds(153, 72, 45, 16);
		btnMan.setText("Man");

		final Button btnKvinna = new Button(composite_1, SWT.RADIO);
		btnKvinna.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				gender = "Female";
			}
		});
		btnKvinna.setText("Kvinna");
		btnKvinna.setBounds(204, 72, 57, 16);

		Button btnSkapaFrfattare = new Button(composite_1, SWT.NONE);
		btnSkapaFrfattare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String firstName = text_2.getText();
				String lastName = text_3.getText();
				String age = text_4.getText();
				String country = text_5.getText();
				String email = text_6.getText();

				// if the gender is set, we create the new author
				if (gender != "") {
					author = new Author();
					author.SetValues(firstName, lastName, age, gender, country,
							email);
					authors.add(author);
					combo.add(author.GetName());
					text_2.setText("");
					text_3.setText("");
					text_5.setText("");
					text_6.setText("");
					text_4.setSelection(0);
					btnMan.setSelection(false);
					btnKvinna.setSelection(false);
				}
			}
		});
		btnSkapaFrfattare.setText("Skapa F\u00F6rfattare");
		btnSkapaFrfattare.setBounds(10, 134, 100, 21);

		Composite composite_2 = new Composite(shell, SWT.NONE);
		composite_2.setBounds(229, 162, 304, 153);

		Label lblSkapaNyKategori = new Label(composite_2, SWT.NONE);
		lblSkapaNyKategori.setText("Skapa ny kategori");
		lblSkapaNyKategori.setBounds(110, 6, 106, 15);

		Label lblNamn_1 = new Label(composite_2, SWT.NONE);
		lblNamn_1.setText("Namn:");
		lblNamn_1.setBounds(10, 30, 57, 15);

		text_7 = new Text(composite_2, SWT.BORDER);
		text_7.setBounds(97, 27, 165, 18);

		Button btnSkapaKategori = new Button(composite_2, SWT.NONE);
		btnSkapaKategori.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				category = new Category();
				String categoryName = text_7.getText();

				if (categoryName != "") {
					category.SetValues(categoryName);
					combo_1.add(category.GetCategory());
					categories.add(category);
				}
				text_7.setText("");
			}
		});
		btnSkapaKategori.setText("Skapa Kategori");
		btnSkapaKategori.setBounds(10, 53, 100, 21);

		Composite composite_3 = new Composite(shell, SWT.NONE);
		composite_3.setBounds(10, 319, 523, 179);

		// the list
		list = new List(composite_3, SWT.BORDER);
		list.setBounds(0, 21, 239, 158);

		Label lblBlogginlgg = new Label(composite_3, SWT.NONE);
		lblBlogginlgg.setText("Blogginl\u00E4gg");
		lblBlogginlgg.setBounds(0, 0, 106, 15);
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});

	}

	public List getList() {
		return list;
	}

}
