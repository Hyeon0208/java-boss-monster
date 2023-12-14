package bossmonster.view;

import bossmonster.view.validator.BossMonsterHpValidator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    public String inputBossMonsterHp() {
        String bossMonsterHp = readLine();
        BossMonsterHpValidator.validate(bossMonsterHp);
        return bossMonsterHp;
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
