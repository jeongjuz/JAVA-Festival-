package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.FestivalPublicDAO;
import model.rec.FestivalPublicVO;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class FestivalPublicView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField FBName;
	private JTextField FBLoc;
	private JTable table;
	private JTextField FBsearch;
	FestivalPublicDAO dao;
	private ListTableModel listTableModel;
	private JTable tbpubliclist;
	private int publicNo;
	private JLabel lblPicPath;
	private JComboBox FPCombox;
	private int festivalNo;
	private JComboBox FPType;

	/**
	 * Create the panel.
	 */
	public FestivalPublicView(int festivalNo) {
		this.festivalNo = festivalNo;

		try {
			dao = new FestivalPublicDAO(festivalNo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setLayout(null);
		setBounds(12, 62, 984, 657);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(522, 121, 417, 488);
		add(scrollPane);

		tbpubliclist = new JTable();
		tbpubliclist.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tbpubliclist.getFont().getStyle(), 12));
		scrollPane.setViewportView(tbpubliclist);
		tbpubliclist.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "\uC2DC\uC124\uD0C0\uC785\uBC88\uD638", "\uACF5\uACF5\uC2DC\uC124\uD0C0\uC785\uBA85",
						"\uACF5\uACF5\uC2DC\uC124\uBA85", "\uACF5\uACF5\uC2DC\uC124\uC704\uCE58" }));
		tbpubliclist.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel_1_2 = new JLabel("??????????????????");
		lblNewLabel_1_2.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_2.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel_1_2.getFont().getStyle(), 20));
		lblNewLabel_1_2.setBounds(46, 70, 121, 24);
		add(lblNewLabel_1_2);

		FPType = new JComboBox();
		FPType.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", FPType.getFont().getStyle(), 14));
		FPType.setModel(new DefaultComboBoxModel(new String[] { "?????????", "?????????", "??????", "?????????", "???????????????" }));
		FPType.setBounds(171, 70, 294, 30);
		add(FPType);

		JLabel lblNewLabel_1 = new JLabel("???????????????");
		lblNewLabel_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", FPType.getFont().getStyle(), 20));
		lblNewLabel_1.setBounds(46, 120, 103, 24);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("??????????????????");
		lblNewLabel_1_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel_1_1.getFont().getStyle(), 20));
		lblNewLabel_1_1.setBounds(46, 167, 121, 24);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("?????? / ??????");
		lblNewLabel_1_1_2_1_1.setForeground(new Color(249, 255, 249));
		lblNewLabel_1_1_2_1_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel_1_1_2_1_1.getFont().getStyle(), 20));
		lblNewLabel_1_1_2_1_1.setBounds(46, 222, 103, 24);
		add(lblNewLabel_1_1_2_1_1);

		FBName = new JTextField();
		FBName.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", FBName.getFont().getStyle(), 16));
		FBName.setColumns(10);
		FBName.setBounds(171, 118, 294, 30);
		add(FBName);

		FBLoc = new JTextField();
		FBLoc.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", FBLoc.getFont().getStyle(), 16));
		FBLoc.setColumns(10);
		FBLoc.setBounds(171, 166, 294, 30);
		add(FBLoc);

		FBsearch = new JTextField();
		FBsearch.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", FBsearch.getFont().getStyle(), 16));

		// ???????????? ?????? ?????? (new)
		FBsearch.setToolTipText("");
		FBsearch.setBounds(522, 70, 417, 40);
		add(FBsearch);
		FBsearch.setColumns(10);

		String searchText[] = { "???????????????", "??????????????????" };
		FPCombox = new JComboBox(searchText);
		FPCombox.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", FPCombox.getFont().getStyle(), 13));
		FPCombox.setBounds(522, 35, 170, 23);
		add(FPCombox);
		
		FBsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     int sel = FPCombox.getSelectedIndex();
			     System.out.println(sel);
		            String text = FBsearch.getText();
		            try {
		            ArrayList list = dao.publicsearch(sel, text);
		            listTableModel.data = list;
		            tbpubliclist.setModel(listTableModel);
		            listTableModel.fireTableDataChanged();
		         } catch (Exception e2) {
		            // TODO: handle exception
		        	 e2.printStackTrace();
		            JOptionPane.showMessageDialog(null, "???????????? ?????? ??????"+e2.getMessage());
		         }		
			}
		});
		
		JButton btnNewButton_1 = new JButton("????????????");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectpublicList();
			}
		});
		btnNewButton_1.setBounds(848, 35, 91, 23);
		add(btnNewButton_1);
		// ???????????? ?????? ???
		

		JButton btnNewButton = new JButton("??????");
		btnNewButton.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnNewButton.getFont().getStyle(), 20));

		// ???????????? ?????? ????????? ?????? (update)
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String publiclocation = FBLoc.getText();
				String publicname = FBName.getText();
				String publictypename = (String) FPType.getSelectedItem();
				String publicPicPath = lblPicPath.getText();
				System.out.println(publicname);
				System.out.println(publiclocation);
				System.out.println(publictypename);

				FestivalPublicVO vo = new FestivalPublicVO(publicNo, publicname, publictypename, publiclocation,
						publicPicPath);
				try {
					dao.FestivalPublicInsert(vo);
					JOptionPane.showMessageDialog(null, "???????????? ????????? ??????????????????.");
					selectpublicList();
					clearScreen();

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "???????????? ?????? ??????");
					e2.printStackTrace();
				}

			}

		});
		// ???????????? ?????? ????????? ???

		btnNewButton.setBounds(46, 568, 109, 41);
		add(btnNewButton);

		JButton FBupdate = new JButton("??????");

		FBupdate.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnNewButton.getFont().getStyle(), 20));
		FBupdate.setBounds(356, 568, 109, 41);
		add(FBupdate);

		// ?????? ?????? ?????? ?????? ?????? (new)
		JButton btnUploadImg = new JButton("?????? ??????");
		btnUploadImg.setBounds(172, 223, 100, 24);
		add(btnUploadImg);

		JLabel lblPicture = new JLabel("");
		lblPicture.setBounds(171, 256, 294, 288);
		add(lblPicture);

		lblPicPath = new JLabel("");
		lblPicPath.setBounds(281, 227, 57, 15);
		add(lblPicPath);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(129, 129, 129));
		separator.setBackground(new Color(179, 179, 179));
		separator.setBounds(493, 34, 2, 574);
		add(separator);
		// ?????? ?????? ?????? ?????? ?????? ???

		// ?????????????????? ?????? ????????? (new)
		btnUploadImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				chooser.setCurrentDirectory(new File("/")); // ?????? ?????? ??????????????? ??????
				chooser.setAcceptAllFileFilterUsed(true); // Fileter ?????? ?????? ??????
				chooser.setDialogTitle("?????? ??????"); // ?????? ??????
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // ?????? ?????? ??????

				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "png");
				chooser.setFileFilter(filter);

				int returnVal = chooser.showOpenDialog(null); // ????????? ??? ??????
				if (returnVal == JFileChooser.APPROVE_OPTION) { // ????????? ??????
					File f = chooser.getSelectedFile(); // ????????? ?????? ????????????
					String workingDir = System.getProperty("user.dir"); // ?????? ????????????(??????????????????)??? ????????????????????? ??????
					String savedFilePath = fileSave(f, workingDir + "\\src\\upload",
							UUID.randomUUID().toString() + ".png");

					// ?????????&????????? ????????? ??????
					ImageIcon img = new ImageIcon(workingDir + savedFilePath); // ????????? - ???????????? ??????
					lblPicture.setIcon(img);
					lblPicPath.setText(savedFilePath); // db ????????? - ???????????? ?????? (\\src\\upload\\*.jpg)

				} else if (returnVal == JFileChooser.CANCEL_OPTION) { // ????????? ??????
					System.out.println("cancel");
				}
			}
		});
		// ?????????????????? ?????? ????????? ???

		listTableModel = new ListTableModel();
		selectpublicList();

		// ???????????? ???????????? ????????? ??????
		tbpubliclist.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tbpubliclist.getSelectedRow();
				int col = 0;
				int publicNo = Integer.parseInt((String) tbpubliclist.getValueAt(row, col));

				FestivalPublicVO vo = new FestivalPublicVO();
				try {
					vo = dao.findByNum(publicNo);

				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "???????????? ?????? ??????" + e1.getMessage(), "??????",
							JOptionPane.INFORMATION_MESSAGE);
				}
				FPType.setSelectedItem(vo.getPublictypename());
				FBName.setText(vo.getPublicname());
				FBLoc.setText(vo.getPubliclocation());

				String workingDir = System.getProperty("user.dir"); // ?????? ????????????(??????????????????)??? ????????????????????? ??????
				// ?????????&????????? ????????? ??????
				System.out.println(vo.getPublicPicturePath());
				ImageIcon img = new ImageIcon(workingDir + vo.getPublicPicturePath()); // ????????? - ???????????? ??????
				lblPicture.setIcon(img);
			}
		});
		// ???????????? ???????????? ????????? ???
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
		background.setBounds(0, 0, 984, 657);
		add(background);

	}

	protected void clearScreen() {
		// TODO Auto-generated method stub
		FBLoc.setText("");
		FBName.setText("");
		FPType.setSelectedItem("?????????");
		lblPicPath.setText("");
		
	}

	// ?????? ?????? ????????? ?????? (new)
	public String fileSave(File file, String path, String name) {
		String filePath = path + "\\" + name;
		try {
			// ???????????? ????????? ??????
			File f = new File(path);
			if (!f.exists()) {
				f.mkdir();
			}
			// ?????? ??????
			int i = 0;
			byte[] buffer = new byte[(int) file.length()];

			DataInputStream dis = new DataInputStream(new FileInputStream(file));

			dis.readFully(buffer);
			dis.close();

			FileOutputStream fos = new FileOutputStream(filePath);
			fos.write(buffer);
			fos.close();
			System.out.println(filePath);
			return "\\src\\upload\\" + name;

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}
	// ?????? ?????? ????????? ???

	void selectpublicList() {
		System.out.println("selectpublicList");
		try {
			ArrayList list = dao.publicList();
			listTableModel.data = list;
			tbpubliclist.setModel(listTableModel);
			listTableModel.fireTableDataChanged();
		} catch (Exception e7) {
			e7.printStackTrace();
		}
	}
	// ?????? ?????? ????????? ???

	class ListTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();

		// update
		String[] colNames = { "??????????????????", "?????????????????????", "???????????????", "??????????????????" };
		////////

		@Override
		public int getColumnCount() {
			// TODO colNamesAuto-generated method stub
			return colNames.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			ArrayList temp = (ArrayList) data.get(rowIndex);
			return temp.get(columnIndex);
		}

		public String getColumnName(int col) {
			return colNames[col];
		}
	}
}
