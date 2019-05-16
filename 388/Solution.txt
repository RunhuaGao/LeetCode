For this problem, there is one point that we should know about:
	The spliter "\n" is to split dic/file, number of "\t" stands for the level(depth)
In this case, we could initially split the string by "\n"
Then for each file name and its level, count its level by the number of "\t"

Next step we have multiple choices: The first two method is to use the HashMap or Array
The most important point here lies with a expression: 
		current level + 1 = current level + file_len

This means that when if the current level is 0(for example, the dir) then we should update the level 1 with the length equals the combination of level 0 's length and the current file's length(notation: there should be an additional 1 standing for the spliter between folders or files)

After that, when come across a file we should intermidiately update the max length by doing comparison between level+1's length and current length


Although the first methods are efficient, the Stack is the best way to solve this problem.

The pointer here is that as the String has its own order, which means that the file/folder has an natural order in the appearance of string. So we do not need to execute bfs/dfs. Juse directly update stack's length

When use stack, the trick part is that when we come across a new upper level folder(for example, cureently the size of stack is 3 means that the current level is 3 and the next name is a folder with a depth 2, we should continue popping the length stored in stack until size of stack < current folder's level(to 1)), then updating the length as above.

Also, keep a variable called curr_len to record the summation of length in stack is a good idea.
