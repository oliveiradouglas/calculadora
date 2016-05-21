//package main;
//
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JTextField;
//import javax.swing.text.BadLocationException;
//
//public class Teste extends JFrame implements ActionListener{
//	
//	private static final long serialVersionUID = 1L;
//	
//	JTextField jtf = new JTextField(10);
//	JTextField jtf2 = new JTextField(10);
//	JButton jb = new JButton("ok");
//	
//	public Teste(){
//		setTitle("Teste");
//		setLayout(new FlowLayout());
//		setSize(200,200);
//		setLocation(600,300);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
//		
//		jtf2.setEditable(false);
//		jb.addActionListener(this);
//		
//		add(jtf);
//		add(jb);
//		add(jtf2);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource() == jb){
//			String[] result = jtf.getText().split(" ");
//			jtf2.setText(result[1]);
//		}
//	}
//
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new Teste();
//	}
//}
package main;

public class Teste{
	public static void main(String[] args){
		String str = "teste 1";
		String[] split = str.split(" ");
		
		try{
			if(split[1] != null){
				System.out.println("Diferente");
				System.out.println(split[1]);
			} else {
				System.out.println("null");
			}
			
		} catch(Exception e){
			System.out.println("Não deu!");
		}

	}
}