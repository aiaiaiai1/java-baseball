package baseball.domain;


import java.util.List;

public class Game {
    private Numbers computerNumbers;
    private final RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();

    public void initiateComputer(){
        computerNumbers = new Numbers(generateRandomNumbers());
    }
    protected List<Integer> generateRandomNumbers(){
        return randomNumbersGenerator.generateNotDuplicateNumbers(3);
    }

    public Result getResult(Numbers userNumbers){
        int ballCount = computerNumbers.contain(userNumbers.getNumbers());
        int strikeCount = computerNumbers.match(userNumbers.getNumbers());
        return new Result(ballCount,strikeCount);
    }
}
