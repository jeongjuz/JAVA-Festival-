package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.BoothInvenDAO;
import model.rec.BoothInvenVO;

public class BoothInventoryView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtInvenName;
	private JTable tblInvenFestivalList;
	private BoothInvenDAO dao;
	private ListTableModel listTableModel;
	private int invNo;
	private JTextField txtInvenNo;
	private JButton btnInvenPlus;
	private JButton btnInvenMinus;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private int boothNo;
	private JSpinner spnInvenCount;

	/**
	 * Create the panel.
	 */

	public BoothInventoryView(int boothNo) {
		this.boothNo = boothNo;
		try {
			dao = new BoothInvenDAO();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		setLayout(null);
		setBounds(12, 62, 984, 657);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(510, 42, 430, 566);
		add(scrollPane);

		tblInvenFestivalList = new JTable();
		tblInvenFestivalList.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		scrollPane.setViewportView(tblInvenFestivalList);
		tblInvenFestivalList.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, 
								 { null, null, null }, { null, null, null },
								 { null, null, null }, { null, null, null }, 
								 { null, null, null }, { null, null, null },
								 { null, null, null }, },

				new String[] { "재고번호", "상품명", "재고수량" }

		));

		// 재고번호 누르면 상품명, 재고수량 불러오기

		listTableModel = new ListTableModel();
		selectinvenlist();

		tblInvenFestivalList.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel = new JLabel("상품명");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel.setBounds(46, 96, 88, 33);
		add(lblNewLabel);

		txtInvenName = new JTextField();
		txtInvenName.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		txtInvenName.setBounds(134, 96, 330, 33);
		add(txtInvenName);
		txtInvenName.setColumns(10);
		
		
		// ---------------      등록 버튼

		
		JButton btnInvReg = new JButton("등록");
		btnInvReg.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnInvReg.getFont().getStyle(), 20));
		btnInvReg.setBounds(46, 568, 100, 40);
		add(btnInvReg);

		btnInvReg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					dao = new BoothInvenDAO();
					String name = txtInvenName.getText();
					System.out.println(name);
					int invcount = (int)spnInvenCount.getValue();
					System.out.println(invcount);
					BoothInvenVO vo = new BoothInvenVO(name, invcount, boothNo);
					
					dao.invenInsert(vo);
					System.out.println("재고 등록 성공");
					JOptionPane.showMessageDialog(null, "재고 등록 완료");
					selectinvenlist();
					clearScreen();
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, e2.getMessage());
					System.out.println("재고 등록 실패");

				}
			}	
		});
		
		
		// ---------------      수정 버튼

		
		JButton btnInvMod = new JButton("수정");
		btnInvMod.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnInvReg.getFont().getStyle(), 20));
		btnInvMod.setBounds(204, 568, 100, 40);
		add(btnInvMod);

		btnInvMod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					dao = new BoothInvenDAO();
					int invnumber = Integer.parseInt(txtInvenNo.getText());
					String name = txtInvenName.getText();
					System.out.println(name);
					int invcount = (int)spnInvenCount.getValue();
					BoothInvenVO vo = new BoothInvenVO(invnumber, name, invcount, boothNo);
					
					dao.invenModify(vo);
					System.out.println("재고 수정 성공");
					JOptionPane.showMessageDialog(null, "재고 수정 완료");
					selectinvenlist();
					clearScreen();
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, e2.getMessage());
					System.out.println("재고 수정 실패");

				}	
			}
		});
		
		
		// ---------------      삭제 버튼
			
		
		JButton btnInvDel = new JButton("삭제");
		btnInvDel.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnInvReg.getFont().getStyle(), 20));
		btnInvDel.setBounds(365, 568, 100, 40);
		add(btnInvDel);
		
		btnInvDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int invno = Integer.parseInt(txtInvenNo.getText());
				
				try {
					dao.invenDelete(invno);
					JOptionPane.showMessageDialog(null, "재고 삭제 완료");
					
					selectinvenlist();
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, e2.getMessage());
					System.out.println("재고 삭제 실패");

				}	
				
			}
		});

		JLabel lblNewLabel_1 = new JLabel("재고수량");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(46, 150, 88, 33);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("재고번호");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(46, 42, 88, 33);
		add(lblNewLabel_2);
		
		txtInvenNo = new JTextField();
		txtInvenNo.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		txtInvenNo.setColumns(10);
		txtInvenNo.setBounds(134, 42, 330, 33);
		add(txtInvenNo);
		
		spnInvenCount = new JSpinner();
		spnInvenCount.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spnInvenCount.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		spnInvenCount.setBounds(134, 150, 109, 33);
		add(spnInvenCount);

		// 마우스 클릭 후 상품 명, 재고 수량 자동 기입
		
		tblInvenFestivalList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tblInvenFestivalList.getSelectedRow();
				int col = 0;
				int invNo = (int) tblInvenFestivalList.getValueAt(row, col);
				BoothInvenVO vo = new BoothInvenVO();
				try {
					vo = dao.findbyno(invNo);
					txtInvenNo.setText(Integer.toString(vo.getInvenno()));
					txtInvenName.setText(vo.getInvenname());
//					spnInvenCount.setText(Integer.toString(vo.getInvencount()));
					spnInvenCount.setValue(vo.getInvencount());

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
		background.setBounds(0, 0, 984, 657);
		add(background);

	}
	
	void clearScreen() {
		txtInvenName.setText("");
		spnInvenCount.setValue(0);
		
	}
	
	void selectinvenlist() {
		try {
			ArrayList list = dao.invenlist(boothNo);
			listTableModel.data = list;
			tblInvenFestivalList.setModel(listTableModel);
			listTableModel.fireTableDataChanged();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	} // 이벤트 등록

	class ListTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] colnames = { "재고번호", "상품명", "재고수량" };

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return colnames.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			ArrayList temp = (ArrayList) data.get(rowIndex);
			return temp.get(columnIndex);
		}

		public String getColumnName(int col) {
			return colnames[col];
		}
		
		
		
}

	
	
	
	
