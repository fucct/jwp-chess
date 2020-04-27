package wooteco.chess.domain.command;

public enum CommandType {
    START("start"),
    STATUS("status"),
    MOVE("move"),
    END("end");

    private final String command;

    CommandType(String command) {
        this.command = command;
    }

    public boolean isSame(String input) {
        return this.command.equalsIgnoreCase(input);
    }


}
