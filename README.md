# RedBlackTree
算法导论(第三版) 红黑树(174-192)的实现

红黑树具体原理见算法导论！
代码实现了一个泛型类。实现的方法如下：
RedBlackTree
CONSTRUCTION: with no parameters

*************************PUBLIC OPERATIONS***************************
void insert(x)			--> Insert x
void delete(x)			--> Delete x
boolean contains         --> Return true if x is found
Comparable findMin()		--> Return smallest item
Comparable findMax()		--> Return largest item
boolean isEmpty()		--> Return true if empty; else false
void makeEmpty()			--> Remove all items
void printTree()			--> Print all items
*************************ERRORS**************************************
Throws Exception if error
