package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.JoinDAO;
import model.rec.JoinVO;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Component;

public class JoinView {

	private JFrame frame;
	private JTextField txtUser;
	private JTextField textID;
	private JTextField textPass;
	private JTextField textBirth;
	private JTextField textPhone;
	JoinDAO dao = null;
	 ImageIcon icon;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public JoinView() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 484, 561);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel JLabeljoin = new JLabel("JOIN");
		JLabeljoin.setForeground(Color.WHITE);
		JLabeljoin.setBounds(45, 53, 400, 40);
		JLabeljoin.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		JLabeljoin.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(JLabeljoin);
		
		txtUser = new JTextField();
		txtUser.setForeground(new Color(255, 255, 255));
		txtUser.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtUser.setOpaque(false);
		txtUser.setSelectionColor(Color.WHITE);
		txtUser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtUser.setBounds(45, 166, 250, 40);
		txtUser.setText("USER");
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		textID = new JTextField();
		textID.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textID.setForeground(new Color(255, 255, 255));
		textID.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textID.setBackground(new Color(255, 255, 255));
		textID.setOpaque(false);
		textID.setBounds(45, 216, 400, 40);
		textID.setText("ID");
		textID.setColumns(10);
		frame.getContentPane().add(textID);
		
		textPass = new JTextField();
		textPass.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textPass.setForeground(new Color(255, 255, 255));
		textPass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textPass.setOpaque(false);
		textPass.setBounds(45, 266, 400, 40);
		textPass.setText("PASSWORD");
		textPass.setColumns(10);
		frame.getContentPane().add(textPass);
		
		textBirth = new JTextField();
		textBirth.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textBirth.setForeground(new Color(255, 255, 255));
		textBirth.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textBirth.setOpaque(false);
		textBirth.setBounds(45, 316, 400, 40);
		textBirth.setText("BIRTH");
		textBirth.setColumns(10);
		frame.getContentPane().add(textBirth);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textPhone.setForeground(new Color(255, 255, 255));
		textPhone.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textPhone.setOpaque(false);
		textPhone.setBounds(45, 366, 400, 40);
		textPhone.setText("PHONENO");
		textPhone.setColumns(10);
		frame.getContentPane().add(textPhone);
		
		JButton btnJoin = new JButton("SIGN UP");
		btnJoin.setOpaque(false);
		btnJoin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnJoin.setVerifyInputWhenFocusTarget(false);
		btnJoin.setForeground(Color.LIGHT_GRAY);
		btnJoin.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.LIGHT_GRAY));
		btnJoin.setBounds(144, 450, 209, 40);
		btnJoin.setBackground(null);
		btnJoin.setBackground(new Color(204, 153, 255));
		frame.getContentPane().add(btnJoin);
		
		JComboBox comMemType = new JComboBox();
		comMemType.setOpaque(false);
		comMemType.setForeground(Color.LIGHT_GRAY);
		comMemType.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.LIGHT_GRAY));
		comMemType.setBounds(45, 116, 400, 40);
		comMemType.setBackground(null);
		comMemType.setModel(new DefaultComboBoxModel(new String[] {"일반회원", "부스관리자", "축제관리자"}));
		frame.getContentPane().add(comMemType);
		
		JComboBox comSex = new JComboBox();
		comSex.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comSex.setOpaque(false);
		comSex.setForeground(Color.LIGHT_GRAY);
		comSex.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.LIGHT_GRAY));
		comSex.setBounds(307, 165, 138, 40);
		comSex.setBackground(null);
		comSex.setModel(new DefaultComboBoxModel(new String[] {"MEN", "WOMEN"}));
		frame.getContentPane().add(comSex);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(JoinView.class.getResource("/img/joinBackground.jpeg")));
		lblNewLabel.setBounds(0, 0, 484, 561);
		frame.getContentPane().add(lblNewLabel);
		
		
		txtUser.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                   txtUser.setText("");
                   
             } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
             }
             }
          
        });
		
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
		
	textPass.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               try {
                  textPass.setText("");
                  
            } catch (Exception e2) {
               // TODO: handle exception
               e2.printStackTrace();
            }
            }
         
       });
	
	textBirth.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            try {
            	textBirth.setText("");
               
         } catch (Exception e2) {
            // TODO: handle exception
            e2.printStackTrace();
         }
         }
      
    });
	
	textPhone.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            try {
            	textPhone.setText("");
               
         } catch (Exception e2) {
            // TODO: handle exception
            e2.printStackTrace();
         }
         }
      
    });
		
		JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(icon.getImage(), 0, 0, null);
                // Approach 2: Scale image to size of component
                // Dimension d = getSize();
                // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                // Approach 3: Fix the image position in the scroll pane
                // Point p = scrollPane.getViewport().getViewPosition();
                // g.drawImage(icon.getImage(), p.x, p.y, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
            
        };
		
        scrollPane = new JScrollPane(background);
		btnJoin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dao = new JoinDAO();
					String membertype = (String)comMemType.getSelectedItem();
					String membersex= (String)comSex.getSelectedItem();
					String name = txtUser.getText();
			 		String id = textID.getText();
			 		String pw  = textPass.getText();
			 		String birth = textBirth.getText();
			 		String phonenumber = textPhone.getText();
			 		int typeno = 0;
			 		
			 		if( "일반회원".equals( membertype)) {
			 			typeno = 1;
			 		} else if ("부스관리자".equals(membertype)) {
			 			typeno = 2;
			 		}else if("축제관리자".equals(membertype)){
			 			typeno = 3;
			 		}
			 		JoinVO vo= new JoinVO(name,id,pw, birth,phonenumber,typeno, membersex);
			 		dao.regist(vo);
			 		
				}catch (Exception e1) {
					e1.printStackTrace();
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				JOptionPane.showMessageDialog(null, "회원가입되었습니다.");
				new LoginView();
				frame.setVisible(false);
				//1.화면에서 값을 다 받아오기
				//2.객체로 만들기
				//3. dao.insertMemeber()
				//4. do
				
				
			}
		});
		
		
	}
}
