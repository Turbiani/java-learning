package method.references;

/**
 * Created by lcunha on 30/04/17.
 */
class Usuario {
    private String nome;
    private int pontos;
    private boolean moderador;

    /**
     * Default Constructor
     */
    public Usuario(){};

    /**
     * @param nome do usuario
     * @param pontos do usuario
     */
    public Usuario(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    /**
     * @param pontos do usuario
     */
    public Usuario(int pontos) {
        this.pontos = pontos;
    }

    /**
     * @param nome do usuario
     */
    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public boolean isModerador() {
        return moderador;
    }

    public void setModerador(boolean moderador) {
        this.moderador = moderador;
    }
    
    public void whoAmi(){
    	System.out.println(getNome()==null ? getPontos() : getNome());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", pontos=" + pontos +
                ", moderador=" + moderador +
                '}';
    }
}
