# Maze Explorers

Maze Explorers reúne várias técnicas de IA (Inteligência Artificial) 
com um objetivo em comum: encontrar a saída do labirinto.
Você pode colocar um ou vários agentes inteligentes para "competir", vendo quem encontra a saída 
do labirinto primeiro em cada cenário.
Dentre as técnicas usadas, temos:
- **Busca Cega:** São técnicas em que o agente não conhece previamente o que tem adiante.
	- Busca em Largura.
	- Busca em Profundidade.
	
- **Busca Heurística:** São  técnicas em que o agente tem uma dica de onde é mais vantajoso passar naquele momento.
	- Busca Greedy
	- Busca A*

![](https://imageshack.com/i/pnc6YM3Fp)

## Iniciando

**Requisitos**

- **Sistema operacional:**

| Sistema Operacional   | Suportado |
|-----------------------|-----------|
| Windows 7, 8, 8.1, 10 | Sim       |
| Linux                 | Sim |
| Mac                   | Sim |

- **Versao do Java**  
No mínimo o Java 8.

- **Configurando o ambiente**
1. Para começar, baixe todo o projeto em arquivo
compactado clicando em baixar. 

2. Extraia o arquivo compactado e o abra em 
sua IDE preferida (desde que tenha suporte a 
linguagem  java).

3. Configure o parâmetro de caminho da JVM
para:
- Windows: 
> -Djava.library.path=natives/nativeWindows/

- Linux:
> -Djava.library.path=natives/nativeLinux/

- Mac:
> -Djava.library.path=natives/nativeMac/

_**Obs:** o programa não está conpilado,
mas você pode compilar e testar._

## Lincença
Este software está sob a licença MIT. Isto significa que:
- [x] A distriuição do software não precisa ser pública.
- [x] Modificações podem estar sob qualquer licença.
- [x] Não há necessidade de documentação do código fonte.
- [x] Não tem nenhuma posição em relação ao uso de patentes.

A licença completa está no arquivo LICENSE, e pode ser acessada [aqui](https://github.com/LucasDeCarvalhoBarbosa/MazeExplorers/blob/master/LICENSE).
# Créditos
- São dados os créditos a biblioteca [Slick2D](http://slick.ninjacave.com/), 
que é usada no projeto para a parte gráfica. A Slick2D é uma biblioteca para jogos em 2D
na linguagem java, e é baseada na [LWJGL](https://www.lwjgl.org/) (Lightweight Java Game Library).  

- Agradecimentos a Charles Gabriel, pelos sprites usados. Link para o seu blog: <http://cgartsenal.blogspot.com/>
