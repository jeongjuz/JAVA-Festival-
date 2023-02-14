package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import model.LoginDAO;
import model.rec.LoginVO;
import model.JoinDAO;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.*;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;


public class LoginView {

	private JFrame frame;
	private JTextField textID;
	private JTextField textpass;
	private JButton btnlogin;
	private LoginDAO dao; 
	private String loginMemberId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {

		initialize();
		
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			dao = new LoginDAO();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 484, 561);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ButtonGroup group = new ButtonGroup();

		JRadioButton radiomember1 = new JRadioButton("일반 회원");
		radiomember1.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		radiomember1.setForeground(UIManager.getColor("CheckBox.background"));
		radiomember1.setOpaque(false);
		radiomember1.setBackground(new Color(204, 153, 255));
		radiomember1.setBounds(100, 198, 80, 25);
		frame.getContentPane().add(radiomember1);

		JRadioButton radiomember3 = new JRadioButton("축제 관리자");
		radiomember3.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		radiomember3.setForeground(UIManager.getColor("CheckBox.background"));
		radiomember3.setOpaque(false);
		radiomember3.setBackground(new Color(204, 153, 255));
		radiomember3.setBounds(184, 198, 100, 25);
		frame.getContentPane().add(radiomember3);

		JRadioButton radiomember2 = new JRadioButton("부스 관리자");
		radiomember2.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		radiomember2.setForeground(UIManager.getColor("CheckBox.background"));
		radiomember2.setOpaque(false);
		radiomember2.setBackground(new Color(204, 153, 255));
		radiomember2.setBounds(276, 198, 100, 25);
		frame.getContentPane().add(radiomember2);

		group.add(radiomember1);
		group.add(radiomember2);
		group.add(radiomember3);

		btnlogin = new JButton("LOGIN");
		btnlogin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnlogin.setOpaque(false);
		btnlogin.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		btnlogin.setForeground(new Color(255, 255, 255));
		btnlogin.setBackground(null);
		btnlogin.setBounds(100, 358, 125, 35);
		frame.getContentPane().add(btnlogin);

		JButton btnjoin = new JButton("JOIN");
		btnjoin.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		btnjoin.setOpaque(false);
		btnjoin.setForeground(new Color(255, 255, 255));
		btnjoin.setBackground(null);
		btnjoin.setBounds(258, 358, 125, 35);
		frame.getContentPane().add(btnjoin);

		textID = new JTextField();
		textID.setForeground(UIManager.getColor("Button.background"));
		textID.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textID.setOpaque(false);
		textID.setBackground(new Color(255, 255, 255));
		textID.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textID.setText("ID");
		textID.setColumns(10);
		textID.setBounds(124, 244, 230, 40);
		frame.getContentPane().add(textID);

		textpass = new JTextField();
		textpass.setForeground(UIManager.getColor("Button.background"));
		textpass.setOpaque(false);
		textpass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textpass.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		textpass.setText("PASSWORD");
		textpass.setColumns(10);
		textpass.setBounds(124, 293, 230, 40);
		frame.getContentPane().add(textpass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/img/loginBackground.jpeg")));
		lblNewLabel.setBounds(0, 0, 484, 561);
		frame.getContentPane().add(lblNewLabel);

		
		textID.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               try {
                  textID.setText("");
                  
            } catch (Exception e2) {
               // TODO: handle exception
               e2.printStackTrace();
            }
            }
         
       });
       textpass.addMouseListener(new MouseAdapter() {
    	   public void mouseClicked(MouseEvent e) {
               try {
                  textpass.setText("");
                  
            } catch (Exception e2) {
               // TODO: handle exception
               e2.printStackTrace();
            }
            }
         
       });
       
           

		btnlogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					String id = textID.getText();
					String pw = textpass.getText();
					int typeno = 0;

					if (radiomember1.isSelected()) {
						typeno = 1;
					} else if (radiomember2.isSelected()) {
						typeno = 2;
					} else if (radiomember3.isSelected()) {
						typeno = 3;
					}
					System.out.println("타입번호; " +typeno);
					LoginVO vo = new LoginVO(id, pw, typeno);
					
					loginMemberId = dao.memberLogin(vo);
					
//					if (dao.memberLogin(vo)) {
//						System.out.println("로그인 성공");
//						
//					} else {
//						
//					}
	
					
				} catch (Exception e3) {
					// TODO: handle exception
					e3.printStackTrace();
				}

				if (radiomember1.isSelected() && loginMemberId != null) {
					JOptionPane.showMessageDialog(null, "로그인되었습니다.");
					MemberManagementView view = new MemberManagementView(loginMemberId);
					frame.setVisible(false);
					
				} else if (radiomember2.isSelected() && loginMemberId != null) {
					JOptionPane.showMessageDialog(null, "로그인되었습니다.");
					new BoothManagementView(1, loginMemberId);
					frame.setVisible(false);
				} else if (radiomember3.isSelected() && loginMemberId != null) {
					JOptionPane.showMessageDialog(null, "로그인되었습니다.");
//					new BoothManagementView(loginMemberId);
					new FestivalManagementView(1, loginMemberId);
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}

			}
		});

		btnjoin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new JoinView();
				frame.setVisible(false);

			}
		});

		btnjoin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new LoginView();
				frame.setVisible(false);

			}
		});

	}
}