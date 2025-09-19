package taskagitmakas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TasKagitMakas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ad;
	private static String isim, secim;
	private static int user=0, computer=0;
	private JLabel adiniz, kullanici, bilgisayar;
	private JPanel panel_2, panel_3;
	private JButton gonder, yeniden, tas, kagit, makas;
	private JLabel secimin;
	private JLabel sonuc1;
	private JLabel sonuc2;
	private JLabel kazanan;
	private JButton tekrar;
	private JLabel sonuc;
	private JLabel sen;
	private JLabel o;
	private JLabel kazanan_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TasKagitMakas frame = new TasKagitMakas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TasKagitMakas() {
		//UYGULAMA AYARLARI
		setTitle("Taş-Kağıt-Makas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 526, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//OYUNCU BİLGİLERİ PANELİ AYARLARI
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255), 5, true), "OYUNCU B\u0130LG\u0130LER\u0130", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(10, 10, 369, 118);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		//İSİM GİRME ALANI
		ad = new JTextField();
		ad.setBounds(112, 32, 240, 28);
		panel_1.add(ad);
		ad.setColumns(10);
		
		adiniz = new JLabel("Adınızı girin:");
		adiniz.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adiniz.setBounds(24, 34, 85, 21);
		panel_1.add(adiniz);
		
		//OYUN ALANI AYARLARI
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setVisible(false);
		panel_2.setBounds(10, 138, 516, 255);
		panel_2.setLayout(null);
		panel.add(panel_2);
		
		//TAŞ-KAĞIT-MAKAS BUTONLARI VE OLAYLARI
		tas = new JButton("");
		tas.setBounds(15, 35, 94, 70);
		tas.setIcon(new ImageIcon("src\\rock.png"));
		
		kagit = new JButton("");
		kagit.setBounds(15, 105, 94, 70);
		kagit.setIcon(new ImageIcon("src\\paper.png"));
		
		makas = new JButton("");
		makas.setBounds(15, 174, 94, 70);
		makas.setIcon(new ImageIcon("src\\scissors.png"));
		
		tas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secim="rock";
				tas.setBackground(Color.green);
				tas.setEnabled(false);
				kagit.setEnabled(false);
				makas.setEnabled(false);
				bilgisayarSec(secim);
			}
		});
		
		kagit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secim="paper";
				kagit.setBackground(Color.green);
				tas.setEnabled(false);
				kagit.setEnabled(false);
				makas.setEnabled(false);
				bilgisayarSec(secim);
			}
		});
		
		makas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secim="scissors";
				makas.setBackground(Color.green);
				tas.setEnabled(false);
				kagit.setEnabled(false);
				makas.setEnabled(false);
				bilgisayarSec(secim);
			}
		});

		panel_2.add(tas);
		panel_2.add(kagit);
		panel_2.add(makas);
		
		secimin = new JLabel("Seçimin:");
		secimin.setFont(new Font("Tahoma", Font.BOLD, 15));
		secimin.setBounds(31, 11, 70, 21);
		panel_2.add(secimin);
		
		//KULLANICI SEÇİMİ
		sonuc1 = new JLabel("");
		sonuc1.setBounds(161, 94, 94, 94);
		panel_2.add(sonuc1);
		
		//BİLGİSAYAR SEÇİMİ
		sonuc2 = new JLabel("");
		sonuc2.setBounds(268, 94, 94, 94);
		panel_2.add(sonuc2);
		
		//KAZANAN BİLGİSİ
		kazanan = new JLabel("Kazanan:");
		kazanan.setVisible(false);
		kazanan.setHorizontalAlignment(SwingConstants.CENTER);
		kazanan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		kazanan.setBounds(404, 112, 79, 21);
		panel_2.add(kazanan);
		
		sonuc = new JLabel("-");
		sonuc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sonuc.setVisible(false);
		sonuc.setBounds(258, 133, 25, 13);
		panel_2.add(sonuc);
		
		//SKOR TABLOSU AYARLARI
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255), 5, true), "SKOR TABLOSU", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_3.setVisible(false);
		panel_3.setBounds(389, 10, 137, 118);
		panel_3.setLayout(null);
		panel.add(panel_3);
		
		//TEKRAR SEÇME BUTONU
		tekrar = new JButton("Tekrar Oyna");
		tekrar.setVisible(false);
		tekrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tekrardan();
			}
		});
		tekrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tekrar.setForeground(new Color(255, 128, 0));
		tekrar.setBounds(204, 194, 120, 28);
		panel_2.add(tekrar);
		
		sen = new JLabel("");
		sen.setVisible(false);
		sen.setFont(new Font("Tahoma", Font.ITALIC, 13));
		sen.setHorizontalAlignment(SwingConstants.CENTER);
		sen.setBounds(161, 71, 94, 20);
		panel_2.add(sen);
		
		o = new JLabel("Bilgisayar");
		o.setVisible(false);
		o.setHorizontalAlignment(SwingConstants.CENTER);
		o.setFont(new Font("Tahoma", Font.ITALIC, 13));
		o.setBounds(268, 71, 94, 20);
		panel_2.add(o);
		
		kazanan_1 = new JLabel("");
		kazanan_1.setVisible(false);
		kazanan_1.setHorizontalAlignment(SwingConstants.CENTER);
		kazanan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		kazanan_1.setBounds(397, 131, 94, 21);
		panel_2.add(kazanan_1);
		
		//YENİ KULLANICI İÇİN BUTON
		yeniden = new JButton("Yeni Tur");
		yeniden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yeniOyun();
			}
		});
		yeniden.setForeground(new Color(0, 128, 64));
		yeniden.setFont(new Font("Tahoma", Font.BOLD, 13));
		yeniden.setBounds(10, 87, 117, 21);
		panel_3.add(yeniden);

		//İSİM GÖNDERME BUTONU
		gonder = new JButton("Gönder");
		gonder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ad.getText().isBlank()) {
					JOptionPane.showMessageDialog(panel, "İsim kısmı boş bırakılamaz.", "Hata!", JOptionPane.ERROR_MESSAGE);
				}else if(ad.getText().length()>13) {
					JOptionPane.showMessageDialog(panel, "İsim 13 karakterden fazla olamaz.", "Hata!", JOptionPane.ERROR_MESSAGE);
				}else {
					isim=ad.getText();
					oyunBasliyor();
				}
			}
		});
		gonder.setForeground(new Color(255, 0, 0));
		gonder.setFont(new Font("Tahoma", Font.BOLD, 18));
		gonder.setBounds(121, 70, 121, 31);
		panel_1.add(gonder);
		
		//KULLANICI SKORU
		kullanici = new JLabel("");
		kullanici.setBounds(10, 28, 117, 13);
		panel_3.add(kullanici);
		
		//BİLGİSAYAR SKORU
		bilgisayar = new JLabel("");
		bilgisayar.setBounds(10, 55, 117, 13);
		panel_3.add(bilgisayar);
	}
	
	private void oyunBasliyor() {
		kullanici.setText(isim+": "+user);
		bilgisayar.setText("Bilgisayar: "+computer);
		panel_2.setVisible(true);
		panel_3.setVisible(true);
		adiniz.setEnabled(false);
		ad.setEnabled(false);
		gonder.setEnabled(false);
	}
	
	private void yeniOyun() {
		ad.setText("");;
		adiniz.setEnabled(true);
		ad.setEnabled(true);
		gonder.setEnabled(true);
		panel_2.setVisible(false);
		panel_3.setVisible(false);
		user=0;
		computer=0;
	}
	
	private void bilgisayarSec(String secim) {
		sonuc1.setIcon(new ImageIcon("src\\"+secim+".png"));
		String pc;
		Random random=new Random();
		int sec=random.nextInt(3);
		if(sec==0) {
			pc="rock";
		}else if(sec==1) {
			pc="paper";
		}else {
			pc="scissors";
		}
		sonuc2.setIcon(new ImageIcon("src\\"+pc+".png"));
		kazanan(secim, pc);
	}
	
	private void kazanan(String secim, String pc) {
		kazanan.setVisible(true);
		kazanan_1.setVisible(true);
		sen.setText(isim);
		sen.setVisible(true);
		o.setVisible(true);
		tekrar.setVisible(true);
		sonuc.setVisible(true);
		if(secim.equals("rock") && pc.equals("paper")) {
			computer++;
			kazanan_1.setText("Bilgisayar");
		}else if(secim.equals("rock") && pc.equals("scissors")) {
			user++;
			kazanan_1.setText(isim);
		}else if(secim.equals("paper") && pc.equals("rock")) {
			user++;
			kazanan_1.setText(isim);
		}else if(secim.equals("paper") && pc.equals("scissors")) {
			computer++;
			kazanan_1.setText("Bilgisayar");
		}else if(secim.equals("scissors") && pc.equals("rock")) {
			computer++;
			kazanan_1.setText("Bilgisayar");
		}else if(secim.equals("scissors") && pc.equals("paper")) {
			user++;
			kazanan_1.setText(isim);
		}else {
			kazanan_1.setText("Yok");
		}
		kullanici.setText(isim+": "+user);
		bilgisayar.setText("Bilgisayar: "+computer);
	}
	
	private void tekrardan() {
		tas.setEnabled(true);
		kagit.setEnabled(true);
		makas.setEnabled(true);
		tas.setBackground(null);
		kagit.setBackground(null);
		makas.setBackground(null);
		sonuc.setVisible(false);
		sonuc1.setIcon(null);
		sonuc2.setIcon(null);
		kazanan.setVisible(false);
		kazanan_1.setVisible(false);
		tekrar.setVisible(false);
		sen.setVisible(false);
		o.setVisible(false);
	}
}
