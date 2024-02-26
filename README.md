
## LOL游戏玩家类型与胜利条件大数据分析
### 1 实验主题 <br>
以五个地区最新联赛比赛的前 100 名玩家数据为样本，爬取到的 2022 年
12 月 19 日最新联赛比赛数据为对象，研究以下内容：<br>
#### 1.1英雄联盟资深玩家用户聚类 <br>
基于爬取并清洗后的数据集，提取可量化的特征数据，对这前 100 名玩家进
行分类。<br>
#### 1.2英雄联盟游戏的重要获胜条件 <br>
以玩家每场游戏相关的各项指标（如野怪信息、人头数、死亡次数等）为参
考，研究游戏胜利的重要条件。<br>
###  2 实验目的 <br>
理解分布式文件系统、非关系型数据库、MapReduce 实现原理、Spark 大数
据分析基础、流式数据分析、数据获取等内容，掌握 pysparksql、pysparkcore、<br>
rdd 的基本使用方法，完成从数据爬取、数据预处理、数据提取、数据建模、数
据分析、数据可视化流程。<br>
###  3 实验环境 <br>
- jupyter+MiniConda+spark-3.3.1+hadoop3本地模式（python3.9）; <br>
- 可视化：seaborn；pyplot；missingno；<br>
- 数据获取：Rriotwatcher；<br>
- 数据处理：pyspark.sql；pyspark.ml；sklearn；pandas；numpy。<br>
### 4 源代码文件
data_grasp.ipynb    网页爬虫源代码<br>
data_deal.ipynb    数据探索性分析、召唤师
data_logistic.ipynb LOL游戏胜利因素分析
#### 数据表文件
matches.csv    网页爬虫结果数据表<br>
result_julei.csv    聚类结果数据表

### 可视化源代码
scala_first    动态数据处理项目文件
