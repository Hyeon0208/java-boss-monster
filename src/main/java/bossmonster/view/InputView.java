package bossmonster.view;

import bossmonster.view.validator.BossMonsterHpValidator;
import bossmonster.view.validator.PlayerNameValidator;
import bossmonster.view.validator.PlayerStatusValidator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    public String inputBossMonsterHp() {
        String bossMonsterHp = readLine();
        BossMonsterHpValidator.validate(bossMonsterHp);
        return bossMonsterHp;
    }

    public String inputPlayerName() {
        String playerName = readLine();
        PlayerNameValidator.validate(playerName);
        return playerName;
    }

    public String inputPlayerStatus() {
        String status = readLine();
        PlayerStatusValidator.validate(status);
        return status;
    }

    private String readLine() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException ioException) {
            return "";
        }
    }
}
