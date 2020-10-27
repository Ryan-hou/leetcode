图的建模和 floodfill

如何把一个算法问题建模为一个图论的问题？
* 图的顶点是什么&图的边是什么
* 屏幕坐标系与数学坐标系的区分，屏幕坐标系左上角为 (0,0)
* 二维坐标与一维坐标的转换:
    C 为屏幕坐标系的列数
    二维转为一维: (x, y) -> x * C + y
    一维转为二维: x = V / C, y = V % C
* 四连通与八连通问题
    四连通 int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} }
* 二维数组的 floodfill 算法 -> 类似于染色，通过 BFS&DFS 像水滴在水中蔓延一样，本质还是遍历
* floodfill 算法的应用
    lc695 岛屿的最大面积 / lc200 岛屿的数量 / lc1020 飞地的数量 
    lc130 被围绕的区域 / lc733 图像渲染(floodfill) / lc1034 边框着色
    lc827 最大人工岛 / 扫雷问题 & 抠图/魔棒 & 消消乐 etc
    