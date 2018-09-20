#2018.9.20
ScrabbleClient.java ScrabblePanel.java 为客户端文件 main在ScrabblePanel中
其余为服务端文件 main在ScrabbleServer中

socket中的参数暂被设置为固定值

现只支持单人游戏，客户端发往服务器端的信息会显示在服务器的命令行中
服务端返回的信息显示在GUI上的messageboard中

ScrabbleGame 和 ScrabblePlayer中的一些逻辑有所更改
系统的大多exception都没有handle

一般流程为：
play
input *n ：输入字母 
voteword :选择要投票的单词
vote：投票 由于只有一个玩家，投票完自动加分
pass: 跳过 游戏结束，显示玩家和得分

