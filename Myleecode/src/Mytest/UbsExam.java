package Mytest;


import java.util.ArrayList;
import java.util.List;


public class UbsExam {

	public static void main(String args[]) {

		List<String> sentence = new ArrayList<>();
		sentence.add("Tom like Lily");
		sentence.add("Lily like Jack");
		sentence.add("Jack do not like Lily");

		List<String> queries = new ArrayList<>();
		//queries.add("Tom");
		//queries.add("Jack Lily");
		//queries.add("Tyson");
		queries.add("Jack");
		queries.add("Lily");
		queries.add("Jack Tyson");
		queries.add("Lily Tom");

		UbsExam ex = new UbsExam();
		ex.queryResult(sentence, queries);

	}

	public List<List<Integer>> queryResult(List<String> sentence, List<String> queries) {
		List<List<Integer>> result = new ArrayList<>();

		int n_queries = queries.size();
		int n_sentence = sentence.size();

		for (int i = 0; i < n_queries; i++)// loop into queries

		{
			String[] qer = queries.get(i).split(" ");

			int n_words = qer.length;
			
			int sentence_flag=0;

			List<Integer> count = new ArrayList<>();

			for (int j = 0; j < n_sentence; j++)// every words loop into sentence

			{

				
				String sen = sentence.get(j);
				
				int word_flag = 0;

				for (int k = 0; k < n_words; k++) // loop in search word

				{
					String word = qer[k];
					if (sen.contains(word)) 
					{
						word_flag++;
					}
					else
					{
						//flag--;
					}
				}//end for all the words

				if (word_flag == n_words)//如果全部关键词都有才返回该句都下标
					
					count.add(j);
				
				else {  //这句话并没有找到要搜索的词
				
					sentence_flag++;
				}
			}//end for sentence
			
			
			
			if(sentence_flag==n_sentence)
			{
				if(count.isEmpty())
					count.add(-1);
			}
				
			result.add(count);//whether count =-1 or count= sentence index
			
			
		}//end for query

		return result;

	}

	public List<List<Integer>> queryResult2(List<String> sentence, List<String> queries) {
		List<List<Integer>> result = new ArrayList<>();

		for (int m = 0; m < queries.size(); m++)
			result.add(new ArrayList<Integer>());

		for (int i = 0; i < queries.size(); i++) // every query
		{

			String qstr[] = queries.get(i).split(" ");

			boolean findnull = false;

			for (int j = 0; j < sentence.size(); j++)// every sentence
			{
				String senstr = sentence.get(j);

				int flag = 0;

				for (int k = 0; k < qstr.length; k++)// every words
				{

					String word = qstr[k];

					if (senstr.contains(word)) {
						flag++;

					}

				} // end for k
				if (flag == qstr.length)// all words in sentence
				{
					result.get(i).add(j);
					findnull = true;// if have find query string in a sentence, the result will not=-1
				}

			} // end for j

			if (!findnull) // if have find nothing,add -1
				result.get(i).add(-1);

		} // end for i

		return result;

	}

}
