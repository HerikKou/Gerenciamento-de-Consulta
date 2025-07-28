
import java.time.LocalDate;
import java.util.*;

public class Main {
    //definindo variaveis globais
    static List<Consulta> listadeConsulta = new ArrayList<>();
    static List<Medico> listadeMedico = new ArrayList<>();
    static List<Paciente> listadePaciente = new ArrayList<>();

    public static void main(String[] args) {
        int op;
        Scanner scann = new Scanner(System.in);

        do {
            System.out.println("------Menu------");
            System.out.println("1- Cadastrar Paciente e Médico");
            System.out.println("2-Agendar uma consulta");
            System.out.println("3-Realizar uma consulta ");
            System.out.println("4-Cancelar uma consulta");
            System.out.println("5-Listar todas as consultas");
            System.out.println("6-Filtrar todas as consultas realizadas pelo Médico");
            System.out.println("7-Mostrar o total de valor recebido por cada médico com base nas consultas realizadas");
            System.out.println("8-Sair");
            System.out.println("Escolha sua Opção:");
            op = scann.nextInt();
            switch (op) {
                case 1 -> cadastrar(scann);
                case 2 -> agendarConsulta(scann);
                case 3 -> realizarConsulta(scann);
                case 4 -> cancelarConsulta(scann);
                case 5 -> ListarTudo();
                case 6 -> filtrar(scann);
                case 7 -> mostarTotal(scann);
                case 8 -> System.out.println("Sistema encerrado");
                default -> System.out.println("Opção inválida");

            }
        } while (op != 8);
        scann.close();
    }

    public static void cadastrar(Scanner scann) {
        System.out.println("=================Informações do Medico============");
        System.out.println("==================================================");
        System.out.println("Digite o ID do médico:");
        Long id = scann.nextLong();// Long para armazenar varios ID

        scann.nextLine();

        System.out.println("Digite o nome do médico:");
        String nomeMedico = scann.nextLine();

        System.out.println("Digite a especialidade do Médico");
        String especialidade = scann.nextLine();
        Medico medicos = new Medico(id, nomeMedico, especialidade);
        listadeMedico.add(medicos);
        System.out.println("==================================================");
        System.out.println("=================Informações do Paciente============");
        System.out.println("==================================================");
        System.out.println("Digite o ID do paciente:");
        Long ID = scann.nextLong();// Long para armazenar varios ID
        scann.nextLine();

        System.out.println("Digite o nome do Paciente:");
        String nomePaciente = scann.nextLine();
        System.out.println("Digite a idade:");
        int idade = scann.nextInt();
        Paciente pacientes = new Paciente(ID, nomePaciente, idade);
        listadePaciente.add(pacientes);
        System.out.println("==================================================");
        System.out.println("Informações cadastradas com sucesso");
        System.out.println("==================================================");
    }

    public static void agendarConsulta(Scanner scann) {
        if (listadeMedico.isEmpty() || listadePaciente.isEmpty()) {
            System.out.println("Nenhuma Médico ou Paciente cadastrado");
            return;
        }
        scann.nextLine();

        for (Medico medicos : listadeMedico) {//Percorre a lista de médicos e mostra na tela
            System.out.println(medicos);//imprime no terminal
        }
        System.out.print("Digite o nome do Médico:");//pergunta o nome do médico
        String nomeMedico = scann.nextLine();
        Medico medicoSelecionado = null;//Armazena os nomes dos médicos selecionados
        for (Medico medicos : listadeMedico) {
            if (nomeMedico.equalsIgnoreCase(medicos.getNome())) {//valida se o nome do médico é igual ou naão 
                medicoSelecionado = medicos;//guarda o nome 
            }

        }
        for (Paciente pacientes : listadePaciente) {//percorre a çista de pacientes e mostra na tela
            System.out.println(pacientes);//imprime na tela
        }
        System.out.print("Digite o nome do Paciente:");//pergunta o nome do paciente
        String nomePaciente = scann.nextLine();
        Paciente pacienteSelecionado = null;//armazenar os nomes dos pacientes
        for (Paciente pacientes : listadePaciente) {
            if (nomePaciente.equalsIgnoreCase(pacientes.getNome())) {//valida se o nome é igual ou não
                pacienteSelecionado = pacientes;//gurada o nome do paciente
            }

        }

        //informações para guardar o agendamento
        System.out.print("Digite o ID da consulta:");
        Long id = scann.nextLong();
        scann.nextLine();
        LocalDate date = LocalDate.of(2025, 4, 4);
        StatusConsulta status = StatusConsulta.AGENDADA;//seta o valor da consulta como AGENDADO
        System.out.print("Digite o valor da consulta:");
        double valor = scann.nextDouble();
        Consulta consultas = new Consulta(id, medicoSelecionado, pacienteSelecionado, date, status, valor);

        listadeConsulta.add(consultas);
        System.out.println("==================================================");
        System.out.println("Consulta Agendada com sucesso!");
        System.out.println("==================================================");
    }

    public static void realizarConsulta(Scanner scann) {
        if (listadeMedico.isEmpty() || listadePaciente.isEmpty()) {
            System.out.println("Nenhuma Médico ou Paciente cadastrado");
            return;
        }
        for (Consulta consulta : listadeConsulta) {//Mostra os usuários cadastrados
            System.out.println(consulta);

        }
        scann.nextLine();
        System.out.println("digite o nome do paciente");///Pergunta o nome do paciente
        String nomePaciente = scann.nextLine();
        for (Consulta consulta : listadeConsulta) {//Percorre a lista de consulta
            if (!nomePaciente.equalsIgnoreCase(consulta.getPaciente().getNome())) {//valida se o nome não for igual
                System.out.println("Paciente não encontrado");
                return;
            } else if(nomePaciente.equalsIgnoreCase(consulta.getPaciente().getNome())){
                 if(consulta.getStatus() == StatusConsulta.AGENDADA){//Compara o status com o valor anterior do agendamento
                    consulta.setStatus(StatusConsulta.REALIZADA);//Muda o valor do status para REALIZADA
                }
              
                System.out.println("==================================================");
                System.out.println("Consulta realizada com sucesso!");
                System.out.println("==================================================");
            }
        }
    }

    public static void cancelarConsulta(Scanner scann) {
        if (listadeMedico.isEmpty() || listadePaciente.isEmpty()) {//verifica se a lista esta vazia
            System.out.println("Nenhuma Médico ou Paciente cadastrado");
            return;
        }
        for (Consulta consulta : listadeConsulta) {
            System.out.println(consulta);

        }
        scann.nextLine();
        System.out.println("digite o nome do paciente");
        String nomePaciente = scann.nextLine();
        for (Consulta consulta : listadeConsulta) {
            if (!nomePaciente.equalsIgnoreCase(consulta.getPaciente().getNome())) {
                System.out.println("Paciente não encontrado");
                return;
            } else if(nomePaciente.equalsIgnoreCase(consulta.getPaciente().getNome())){
                    if (consulta.getStatus() == StatusConsulta.AGENDADA || consulta.getStatus() == StatusConsulta.REALIZADA) {//Compara o status com o valor anterior do agendamento
                        consulta.setStatus(StatusConsulta.CANCELADA);//Muda o valor do Status para CANCELADA
                    }
            }
              
            
                System.out.println("==================================================");
                System.out.println("Consulta Cancelada");
                System.out.println("==================================================");
            }
        
    }

    public static void ListarTudo() {
if (listadeMedico.isEmpty() || listadePaciente.isEmpty()) {
            System.out.println("Nenhuma Médico ou Paciente cadastrado");
            return;
    }
    for (Consulta consulta : listadeConsulta){
               System.out.println("==================================================");
            System.out.println(consulta);
          System.out.println("==================================================");
        }
    }

    public static void filtrar(Scanner scann) {
        for (Medico medicos : listadeMedico) {
            System.out.println(medicos);
        }
        scann.nextLine();
        System.out.println("Digite o ID do médico:");
        Long id = scann.nextLong();
        listadeConsulta.stream().filter(consultas -> id == consultas.getMedico().getId()&& consultas.getStatus() == StatusConsulta.REALIZADA).forEach(System.out::println);
    }

    public static void mostarTotal(Scanner scann) {
        for (Medico medicos : listadeMedico) {
            System.out.println(medicos);
        }
        scann.nextLine();
        System.out.println("Digite o ID do médico:");
        Long id = scann.nextLong();
         listadeConsulta.stream().filter(consultas -> id == consultas.getMedico().getId()).map(consultas -> consultas.getValor()).forEach(System.out::println);

    }

}
