package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.BoothProgramDAO;
import model.rec.BoothProgramVO;
import view.MemberBoothView.ListTableModel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class BoothProgramView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tfProgramName;
	private JTextField tfProgramMax;
	private JTable tbProgramList;
	private JTextField textField_8;
	private ListTableModel listTableModel;
	private BoothProgramDAO programDAO;
	private int boothNo;
	private JTextField tfProgramNo;
	private JTextArea taProgramContent;

	/**
	 * Create the panel.
	 */
	// Design 패널에서 화면 안 보이면 이 생성자 주석처리
	//public BoothProgramView() {
		// TODO Auto-generated constructor stub
	//}

	public BoothProgramView(int boothNo) {
		setLayout(null);
		setBounds(12, 62, 984, 657);
		this.boothNo = boothNo;

		try {
			programDAO = new BoothProgramDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(510, 96, 430, 512);
		add(scrollPane);

		tbProgramList = new JTable();
		tbProgramList.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tbProgramList.getFont().getStyle(), 12));
		scrollPane.setViewportView(tbProgramList);
		tbProgramList.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, "" }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "\uACF5\uC5F0\uBA85", "\uACF5\uC5F0\uC7A5\uC18C", "\uC2DC\uC791\uC2DC\uAC04",
						"\uC885\uB8CC\uC2DC\uAC04", "\uCD9C\uC5F0\uC9C4" }));
		tbProgramList.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel = new JLabel("프로그램명");
		lblNewLabel.setForeground(new Color(250, 255, 248));
		lblNewLabel.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lblNewLabel.setBounds(30, 96, 96, 25);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("최대인원");
		lblNewLabel_1.setForeground(new Color(250, 255, 248));
		lblNewLabel_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel.getFont().getStyle(), 20));
		lblNewLabel_1.setBounds(30, 142, 88, 25);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("내용");
		lblNewLabel_1_1_2_1_1.setForeground(new Color(250, 255, 248));
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2_1_1.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel_1_1_2_1_1.getFont().getStyle(), 20));
		lblNewLabel_1_1_2_1_1.setBounds(30, 184, 96, 355);
		add(lblNewLabel_1_1_2_1_1);

		tfProgramName = new JTextField();
		tfProgramName.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfProgramName.getFont().getStyle(), 14));
		tfProgramName.setBounds(134, 96, 330, 25);
		add(tfProgramName);
		tfProgramName.setColumns(10);

		tfProgramMax = new JTextField();
		tfProgramMax.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfProgramMax.getFont().getStyle(), 14));
		tfProgramMax.setColumns(10);
		tfProgramMax.setBounds(134, 142, 330, 25);
		add(tfProgramMax);

		taProgramContent = new JTextArea();
		taProgramContent.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", taProgramContent.getFont().getStyle(), 14));
		taProgramContent.setBounds(134, 184, 330, 355);
		add(taProgramContent);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", textField_8.getFont().getStyle(), 16));
		textField_8.setToolTipText("");
		textField_8.setBounds(510, 42, 430, 40);
		add(textField_8);
		textField_8.setColumns(10);

		JButton btnProgramRegist = new JButton("등록");
		btnProgramRegist.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnProgramRegist.getFont().getStyle(), 20));
		btnProgramRegist.setBounds(44, 568, 100, 40);
		add(btnProgramRegist);

		JButton btnProgramModify = new JButton("수정");
		btnProgramModify.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnProgramRegist.getFont().getStyle(), 20));
		btnProgramModify.setBounds(205, 568, 100, 40);
		add(btnProgramModify);

		JButton btnProgramDelete = new JButton("삭제");
		btnProgramDelete.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", btnProgramRegist.getFont().getStyle(), 20));
		btnProgramDelete.setBounds(364, 568, 100, 40);
		add(btnProgramDelete);

		JLabel lblNewLabel_2 = new JLabel("번호");
		lblNewLabel_2.setForeground(new Color(250, 255, 248));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", lblNewLabel_2.getFont().getStyle(), 20));
		lblNewLabel_2.setBounds(30, 52, 96, 25);
		add(lblNewLabel_2);

		tfProgramNo = new JTextField();
		tfProgramNo.setFont(new Font("\uD55C\uCEF4 \uACE0\uB515", tfProgramNo.getFont().getStyle(), 14));
		tfProgramNo.setColumns(10);
		tfProgramNo.setBounds(134, 52, 330, 25);
		add(tfProgramNo);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(129, 129, 129));
		separator.setBackground(new Color(179, 179, 179));
		separator.setBounds(486, 41, 2, 568);
		add(separator);

		listTableModel = new ListTableModel();
		selectProgramList();

		tbProgramList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbProgramList.getSelectedRow();
				int col = 0;
				int programNo = (int) tbProgramList.getValueAt(row, col);
				try {
					BoothProgramVO vo = programDAO.programDetail(programNo);
					System.out.println(vo.getProgramName());
					tfProgramNo.setText(Integer.toString(vo.getProgramNo()));
					tfProgramName.setText(vo.getProgramName());
					tfProgramMax.setText(Integer.toString(vo.getProgramMax()));
					taProgramContent.setText(vo.getProgramContent());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnProgramRegist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String proName = tfProgramName.getText();
				int proMax =  Integer.parseInt(tfProgramMax.getText());
				String proContent = taProgramContent.getText();
				BoothProgramVO vo = new BoothProgramVO(boothNo, proName, proMax, proContent);
				try {
					programDAO.registProgram(vo);
					JOptionPane.showMessageDialog(null,"프로그램 등록을 완료했습니다.");
					selectProgramList();
					clearScreen();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnProgramDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int programNo = Integer.parseInt(tfProgramNo.getText());
				try {
					programDAO.deleteProgram(programNo);
					JOptionPane.showMessageDialog(null,"프로그램 삭제를 완료했습니다.");
					selectProgramList();
					clearScreen();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MemberBoothView.class.getResource("/img/background_2.jpeg")));
		background.setBounds(0, 0, 984, 657);
		add(background);

	}
	
	void clearScreen() {
		tfProgramNo.setText("");
		tfProgramName.setText("");
		tfProgramMax.setText("");
		taProgramContent.setText("");
	}

	void selectProgramList() {
		System.out.println("selectBoothList");
		try {
			ArrayList list = programDAO.programList(boothNo);
			listTableModel.data = list;
			tbProgramList.setModel(listTableModel);
			listTableModel.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 테이블 모델 클래스
	class ListTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] colNames = { "프로그램번호", "프로그램명", "프로그램내용", "최대인원" };

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return colNames.length;
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
			return colNames[col];
		}
	}
}
