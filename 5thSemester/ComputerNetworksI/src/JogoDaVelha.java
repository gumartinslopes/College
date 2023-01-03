
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// import java.lang.Object; 
import java.awt.Color;

public class JogoDaVelha extends JFrame {
	private int lenMatriz = 3;
	public String nomeJogador = "";
	public String nomeOponente = "";
	private Cliente cliente;

	JLabel lblNomeJogador = new JLabel();
	JLabel lblNomeJogo = new JLabel();
	
	public int[][] matrizVelha = {
									  {0, 0, 0},
									  {0, 0, 0},
									  {0, 0, 0}
								  };
	
	private JPanel contentPane;
	public JButton[][] matrizVelhaBotao = new JButton[lenMatriz][lenMatriz];

	public BtnBound[][] matrixBtnBounds = {
		//linha 0
		{
			new BtnBound(125, 72, 50, 50), //coluna 0
			new BtnBound(185, 72, 50, 50), //coluna 1
			new BtnBound(245, 72, 50, 50) 	//coluna 2
		},
		//linha 1
		{
			new BtnBound(125, 133, 50, 50),//coluna 0
			new BtnBound(185, 133, 50, 50),//coluna 1
			new BtnBound(245, 133, 50, 50)	//coluna 2
		},
		//linha 2
		{
			new BtnBound(125, 190, 50, 50),//coluna 0
			new BtnBound(185, 190, 50, 50),//coluna 1
			new BtnBound(245, 190, 50, 50)	//coluna 2
		},
	};

	
	public JogoDaVelha(String nomeJogador, String nomeOponente, Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		this.nomeJogador = nomeJogador;
		this.nomeOponente = nomeOponente;
		this.cliente = cliente;
		
		lblNomeJogador.setText(this.nomeJogador);
		lblNomeJogo.setText(this.nomeJogador + " Vs. " + this.nomeOponente);
		montaMatriz(layeredPane);
		
		JLabel lblJogador = new JLabel("Turno:");
		lblJogador.setBounds(10, 11, 78, 14);
		layeredPane.add(lblJogador);
		
		lblNomeJogador.setBounds(98, 11, 229, 14);
		layeredPane.add(lblNomeJogador);
		
		JLabel lblJogo = new JLabel("Jogadores:");
		lblJogo.setBounds(10, 32, 78, 14);
		layeredPane.add(lblJogo);
		
		lblNomeJogo.setBounds(98, 32, 229, 14);
		layeredPane.add(lblNomeJogo);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setBounds(10, 57, 404, 194);
		layeredPane.add(panel);
		
		if (Integer.parseInt(cliente.getId()) > Integer.parseInt(cliente.getIdOponente())){
			habilitaBotoes();
		}
	}

	public void montaMatriz(JLayeredPane layeredPane){
		for(int i = 0; i < lenMatriz; i++){
			for(int  j = 0; j < lenMatriz; j++){
				matrizVelhaBotao[i][j] = new JButton("");
				JButton btn = matrizVelhaBotao[i][j];
				final int linha = i;
				final int coluna = j;
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(btn.getText() != "")
							return;
						btn.setText("O");
						cliqueBotaoVelha(linha, coluna);
						habilitaBotoes();
					}
				});
				BtnBound btnConfig = matrixBtnBounds[i][j];
				btn.setBounds(btnConfig.x, btnConfig.y, btnConfig.width, btnConfig.height);
				layeredPane.add(btn);
			}
		}
	}

	public void habilitaBotoes() {
		for(int i=0; i < 3; i++){
			for(int j=0; j < 3; j++){
				if(this.matrizVelhaBotao[i][j].isEnabled()){
					this.matrizVelhaBotao[i][j].setEnabled(false);
					lblNomeJogador.setText(nomeOponente);
				}else{
					this.matrizVelhaBotao[i][j].setEnabled(true);
					lblNomeJogador.setText(nomeJogador);
				}
			}
		}	
	}
	
	public void preencheMatriz(int linha, int coluna, int valor) {
		this.matrizVelha[linha][coluna] = valor;
	}
	
	public int verificaMatriz() {		
		int retornoColunas, retornoLinhas, retornoDiagonais = 0;
		retornoColunas = checaColunas();
		retornoLinhas = checaLinhas();
		retornoDiagonais = checaDiagonais();
		
		if(retornoColunas == -1 || retornoLinhas == -1 || retornoDiagonais == -1){
			return -1;
		}
		
		if(retornoColunas == 1 || retornoLinhas == 1 || retornoDiagonais == 1){
			return 1;
		}
		
		for(int i=0; i < 3; i++){
			for(int j=0; j < 3; j++){
				if(matrizVelha[i][j] == 0){
					return 0;
				}
			}
		}
		
		limparVelha();
		JOptionPane.showMessageDialog(null, "Deu Velha!");	
		return 2;
	}
	
	 public int checaLinhas(){
        for(int linha=0 ; linha<3 ; linha++){
            if( (this.matrizVelha[linha][0] + this.matrizVelha[linha][1] + this.matrizVelha[linha][2]) == -3)
                return -1;
            if( (this.matrizVelha[linha][0] + this.matrizVelha[linha][1] + this.matrizVelha[linha][2]) == 3)
                return 1;
        }
		
        return 0;       
    }
	    
    public int checaColunas(){
        for(int coluna=0 ; coluna<3 ; coluna++){
            if( (this.matrizVelha[0][coluna] + this.matrizVelha[1][coluna] + this.matrizVelha[2][coluna]) == -3)
                return -1;
            if( (this.matrizVelha[0][coluna] + this.matrizVelha[1][coluna] + this.matrizVelha[2][coluna]) == 3)
                return 1;
        }

        return 0;       
    }
    
    public int checaDiagonais(){
        if( (this.matrizVelha[0][0] + this.matrizVelha[1][1] + this.matrizVelha[2][2]) == -3)
            return -1;
        if( (this.matrizVelha[0][0] + this.matrizVelha[1][1] + this.matrizVelha[2][2]) == 3)
            return 1;
        if( (this.matrizVelha[0][2] + this.matrizVelha[1][1] + this.matrizVelha[2][0]) == -3)
            return -1;
        if( (this.matrizVelha[0][2] + this.matrizVelha[1][1] + this.matrizVelha[2][0]) == 3)
            return 1;
        
        return 0;
    }
    
    public int cliqueBotaoVelha(int linha, int coluna) {
    	try {
			cliente.enviaDados("jogar;" + cliente.getId() + ";" + linha + ";" + coluna);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	int valor = 1;

		preencheMatriz(linha, coluna, valor);
		int retorno = verificaMatriz();
		if(retorno == 1){
			JOptionPane.showMessageDialog(null, nomeJogador+" ganhou!");
			limparVelha();
			return 0;
		}else if(retorno == -1){
			JOptionPane.showMessageDialog(null, nomeOponente+" ganhou!");
			limparVelha();
			return 0;
		}else if(retorno == 2){
			return 0;
		}
		
		return valor;
    }
    
    public void limparVelha(){
		for(int i = 0;  i < lenMatriz; i++){
			for(int j = 0; j < lenMatriz; j++){
				matrizVelha[i][j] = 0;				
				matrizVelhaBotao[i][j].setText("");
			}
		}	
    }
}
