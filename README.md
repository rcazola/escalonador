# escalonador

Round Robin
Round-robin (RR) é um dos algoritmos mais simples de agendamento de processos em um sistema operacional, que atribui frações de tempo para cada processo em partes iguais e de forma circular, manipulando todos os processos sem prioridades. 
O funcionamento deste algoritmo acontece da seguinte forma: uma unidade de tempo, denominada quantum, é definida pelo sistema operacional, que determina o período de tempo entre cada sinal de interrupção. Todos os processos são armazenados em uma fila circular.

O escalonador round robin cria um processo que possui atributos proprios como numero de processos tempos de quantum chegada, saida termino e numero do ciclos de processamento ele aloca da melhor forma possivel de acordo com o quantum e o tempo de chegada do processo, é oque chamados de alocação dinamica 

quando esses processos sao criados sao inceridos numa fila de processos onde aguardam o tempo de processamento e se nao forem concluidos apos o quantum, vao para a fila de I/O 

 public void adicionainicio(Processo processo) 
 o metodo adicionainicio, adiciona o processo no começo da lista e exibe mensagem de erro caso a lista estiver cheia 
	
 public void adicionafinal(Processo processo)
 
o metodo adicionafinal, adiciona o processo no fim da lista e exibe mensagem de erro caso a lista estiver cheia 
		
  public Processo removerinicio() 
  
  o metodo removerinicio, remove o processo no começo da lista e exibe mensagem de erro caso a lista estiver vazia 
  
  void inicializarLista(int quantProcessos)
  a primeira coisa é inserir o tamanho do quantum e inicializar a fila de processos e a fila de chegada, depois atribui o respectivo numero de procecessos (tempo e ciclo).
   por fim verifica os processos que estao em I/O e ordena a fila por ordem de chegada
   
   void processarLista(int quantProcessos)
    inicia a simulação primeiro verifica se existem processos chegando, depois se existem processos na fila antes de finalizar o quantum
     
     
     
