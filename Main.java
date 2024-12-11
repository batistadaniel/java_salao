import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Salao salao = new Salao("Salao Beleza Rapida", entrada);
        Menus menus = new Menus();

        salao.menu();
    }
}

class Menus {

    // metodo void, ou seja, sem retorno
    void tituloInicial() {
        System.out.println();
        System.out.println("*************** BEM VINDO ***************");
        System.out.println();
    }
}

class Salao {
    private String nome;
    private final Scanner entrada;
    private ArrayList<Administrador> administradores = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Servico> servicos = new ArrayList<>();
    private ArrayList<Agendamento> agendamentos = new ArrayList<>();

    public Salao(String nome, Scanner entrada) {
        this.nome = nome;
        this.entrada = entrada;
    }

    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Scanner getEntrada() {
        return entrada;
    }

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    public ArrayList<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(ArrayList<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public void menu() {
        int opcao;

        do {
            System.out.println();
            System.out.println("*************** BEM VINDO " + this.nome + " ***************");
            System.out.println();
            System.out.println(">>>>> Escolha uma opcao:");
            System.out.println();
            System.out.println("1. Cadastrar usuario");
            System.out.println("2. Listar usuario");
            System.out.println("3. Login");
            System.out.println("4. Sair");

            System.out.print(">>>>> ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    login();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 2);
    }

    private void cadastrarUsuario() {
        int user;

        System.out.println();

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("Telefone: ");
        String telefone = entrada.nextLine();

        System.out.print("CPF: ");
        String cpf = entrada.nextLine();

        System.out.print("Email: ");
        String email = entrada.nextLine();

        System.out.print("Senha: ");
        String senha = entrada.nextLine();

        System.out.println("Tipo de Usuario: ");
        System.out.println(">>> 1. Administrador");
        System.out.println(">>> 2. Funcionario");
        System.out.println(">>> 3. Cliente");
        user = entrada.nextInt();

        switch (user) {
            case 1: // Administrador
                Administrador administrador = new Administrador(nome, telefone, cpf, email, senha, "Administrador");
                administradores.add(administrador); // Adiciona à lista de administradores
                System.out.println("Administrador cadastrado com sucesso!");
                break;
            case 2: // Funcionario
                Funcionario funcionario = new Funcionario(nome, telefone, cpf, email, senha, "Funcionario");
                funcionarios.add(funcionario); // Adiciona à lista de funcionários
                System.out.println("Funcionario cadastrado com sucesso!");
                break;
            case 3: // Cliente
                Cliente cliente = new Cliente(nome, telefone, cpf, email, senha, "Cliente");
                clientes.add(cliente); // Adiciona à lista de clientes
                System.out.println("Cliente cadastrado com sucesso!");
                break;
            default:
                System.out.println("Opcao invalida! Usuario nao cadastrado.");
        }


    }

    private void listarUsuarios() {
        System.out.println();
        System.out.println("*************** Lista de Usuarios ***************");
        System.out.println();

        // verifica se nao existem departamentos cadastrados
        if (administradores.isEmpty() && clientes.isEmpty() && funcionarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            // Lista Administradores
            System.out.println(">> Administradores:");
            if (administradores.isEmpty()) {
                System.out.println("Nenhum administrador cadastrado.");
            } else {
                for (int i = 0; i < administradores.size(); i++) {
                    System.out.println((i + 1) + " - " + administradores.get(i).getNome() + " (Administrador)");
                }
            }

            // Lista Clientes
            System.out.println("\n>> Clientes:");
            if (clientes.isEmpty()) {
                System.out.println("Nenhum cliente cadastrado.");
            } else {
                for (int i = 0; i < clientes.size(); i++) {
                    System.out.println((i + 1) + " - " + clientes.get(i).getNome() + " (Cliente)");
                }
            }

            // Lista Funcionários
            System.out.println("\n>> Funcionários:");
            if (funcionarios.isEmpty()) {
                System.out.println("Nenhum funcionário cadastrado.");
            } else {
                for (int i = 0; i < funcionarios.size(); i++) {
                    System.out.println((i + 1) + " - " + funcionarios.get(i).getNome() + " (Funcionário)");
                }
            }
        }
    }

    private void login() {

//        Administrador administrador = new Administrador();
//        Cliente cliente = new Cliente();
//        Funcionario funcionario = new Funcionario();

        System.out.println("Login");
        System.out.println();

        System.out.print("Email: ");
        String email = entrada.nextLine();

        System.out.print("Senha: ");
        String senha = entrada.nextLine();

        // Busca o usuario na lista de clientes ou funcionarios
        // Se encontrar, loga e mostra menu principal

        boolean usuarioEncontrado = false;
        for (Administrador admin : administradores) {
            if (admin.getEmail().equals(email) && admin.getSenha().equals(senha)) {
                usuarioEncontrado = true;
                System.out.println("\nLogin efetuado com sucesso! Bem-vindo, Administrador.");
                Administrador.menuAdministrador();
                break;
            }
        }

        // Verifica na lista de funcionários
        if (!usuarioEncontrado) {
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getEmail().equals(email) && funcionario.getSenha().equals(senha)) {
                    usuarioEncontrado = true;
                    System.out.println("\nLogin efetuado com sucesso! Bem-vindo, Funcionário.");
                    menuFuncionario();
                    break;
                }
            }
        }

        // Verifica na lista de clientes
        if (!usuarioEncontrado) {
            for (Cliente cliente : clientes) {
                if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                    usuarioEncontrado = true;
                    System.out.println("\nLogin efetuado com sucesso! Bem-vindo, Cliente.");
                    menuCliente();
                    break;
                }
            }
        }

        // Caso não encontre o usuário
        if (!usuarioEncontrado) {
            System.out.println("\nErro: Email ou senha incorretos. Tente novamente.");
        }
    }

}

class Usuario {

    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private String senha;
    private String tipoUsuario;

    public Usuario(String nome, String telefone, String cpf, String email, String senha, String tipoUsuario) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}

class Administrador extends Usuario {



    public Administrador(String nome, String telefone, String cpf, String email, String senha, String tipoUsuario) {
        super(nome, telefone, cpf, email, senha, "Administrador");
    }

    private menuAdministrador() {

    }

}

class Cliente extends Usuario {

    public Cliente(String nome, String telefone, String cpf, String email, String senha, String tipoUsuario) {
        super(nome, telefone, cpf, email, senha, "Cliente");
    }
}

class Funcionario extends Usuario {

    public Funcionario(String nome, String telefone, String cpf, String email, String senha, String tipoUsuario) {
        super(nome, telefone, cpf, email, senha, "Funcionario");
    }
}

class Servico {

    private Administrador administrador;
    private String nome;
    private String descricao;
    private String codigo;
    private double preco;
    private final ArrayList<Servico> listaServicos = new ArrayList<>();


    public Servico(String nome, String descricao, String codigo, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.preco = preco;
    }

    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


}



class Agendamento {

    private Servico servico;
    private Cliente cliente;
    private Funcionario funcionario;
    private LocalDate dataAgendamento;
    private LocalTime horaAgendamento;

}
