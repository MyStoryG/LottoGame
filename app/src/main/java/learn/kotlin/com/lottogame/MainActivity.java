package learn.kotlin.com.lottogame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mWinInfo;
    private TextView mResultInfo;
    private Spinner mFirstGameNumber1;
    private Spinner mFirstGameNumber2;
    private Spinner mFirstGameNumber3;
    private Spinner mFirstGameNumber4;
    private Spinner mFirstGameNumber5;
    private Spinner mFirstGameNumber6;

    private Spinner mSecondGameNumber1;
    private Spinner mSecondGameNumber2;
    private Spinner mSecondGameNumber3;
    private Spinner mSecondGameNumber4;
    private Spinner mSecondGameNumber5;
    private Spinner mSecondGameNumber6;

    private Spinner mThirdGameNumber1;
    private Spinner mThirdGameNumber2;
    private Spinner mThirdGameNumber3;
    private Spinner mThirdGameNumber4;
    private Spinner mThirdGameNumber5;
    private Spinner mThirdGameNumber6;

    private Spinner mFourthGameNumber1;
    private Spinner mFourthGameNumber2;
    private Spinner mFourthGameNumber3;
    private Spinner mFourthGameNumber4;
    private Spinner mFourthGameNumber5;
    private Spinner mFourthGameNumber6;

    private Spinner mFifthGameNumber1;
    private Spinner mFifthGameNumber2;
    private Spinner mFifthGameNumber3;
    private Spinner mFifthGameNumber4;
    private Spinner mFifthGameNumber5;
    private Spinner mFifthGameNumber6;

    private Button mResetButton;
    private Button mResultButton;
    private Button mFirstRandomButton;
    private Button mSecondRandomButton;
    private Button mThirdRandomButton;
    private Button mFourthRandomButton;
    private Button mFifthRandomButton;

    private Map<Integer, Integer> mFirstGameNumbers;
    private Map<Integer, Integer> mSecondGameNumbers;
    private Map<Integer, Integer> mThirdGameNumbers;
    private Map<Integer, Integer> mFourthGameNumbers;
    private Map<Integer, Integer> mFifthGameNumbers;

    private Map<Integer, Integer> mWinNumbers;
    private int mBonusNum;
    private StringBuilder mResultText;

    private AdapterView.OnItemSelectedListener mItemSelectedListener = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            onFirstGameItemSelected(parent, position);
            onSecondGameItemSelected(parent, position);
            onThirdGameItemSelected(parent, position);
            onFourthGameItemSelected(parent, position);
            onFifthGameItemSelected(parent, position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstGameNumbers = new HashMap<>();
        mSecondGameNumbers = new HashMap<>();
        mThirdGameNumbers = new HashMap<>();
        mFourthGameNumbers = new HashMap<>();
        mFifthGameNumbers = new HashMap<>();
        mWinNumbers = new HashMap<>();

        setLayout();
        setListener();
        setButton();
        setWinNumber();
    }

    private void setLayout() {
        mWinInfo = findViewById(R.id.win_text);
        mResultInfo = findViewById(R.id.result_text);

        mFirstGameNumber1 = findViewById(R.id.first_number1);
        mFirstGameNumber2 = findViewById(R.id.first_number2);
        mFirstGameNumber3 = findViewById(R.id.first_number3);
        mFirstGameNumber4 = findViewById(R.id.first_number4);
        mFirstGameNumber5 = findViewById(R.id.first_number5);
        mFirstGameNumber6 = findViewById(R.id.first_number6);

        mSecondGameNumber1 = findViewById(R.id.second_number1);
        mSecondGameNumber2 = findViewById(R.id.second_number2);
        mSecondGameNumber3 = findViewById(R.id.second_number3);
        mSecondGameNumber4 = findViewById(R.id.second_number4);
        mSecondGameNumber5 = findViewById(R.id.second_number5);
        mSecondGameNumber6 = findViewById(R.id.second_number6);

        mThirdGameNumber1 = findViewById(R.id.third_number1);
        mThirdGameNumber2 = findViewById(R.id.third_number2);
        mThirdGameNumber3 = findViewById(R.id.third_number3);
        mThirdGameNumber4 = findViewById(R.id.third_number4);
        mThirdGameNumber5 = findViewById(R.id.third_number5);
        mThirdGameNumber6 = findViewById(R.id.third_number6);

        mFourthGameNumber1 = findViewById(R.id.fourth_number1);
        mFourthGameNumber2 = findViewById(R.id.fourth_number2);
        mFourthGameNumber3 = findViewById(R.id.fourth_number3);
        mFourthGameNumber4 = findViewById(R.id.fourth_number4);
        mFourthGameNumber5 = findViewById(R.id.fourth_number5);
        mFourthGameNumber6 = findViewById(R.id.fourth_number6);

        mFifthGameNumber1 = findViewById(R.id.fifth_number1);
        mFifthGameNumber2 = findViewById(R.id.fifth_number2);
        mFifthGameNumber3 = findViewById(R.id.fifth_number3);
        mFifthGameNumber4 = findViewById(R.id.fifth_number4);
        mFifthGameNumber5 = findViewById(R.id.fifth_number5);
        mFifthGameNumber6 = findViewById(R.id.fifth_number6);

        mResetButton = findViewById(R.id.reset_button);
        mResultButton = findViewById(R.id.result_button);
        mFirstRandomButton = findViewById(R.id.first_random);
        mSecondRandomButton = findViewById(R.id.second_random);
        mThirdRandomButton = findViewById(R.id.third_random);
        mFourthRandomButton = findViewById(R.id.fourth_random);
        mFifthRandomButton = findViewById(R.id.fifth_random);

    }

    private void setListener() {
        mFirstGameNumber1.setOnItemSelectedListener(mItemSelectedListener);
        mFirstGameNumber2.setOnItemSelectedListener(mItemSelectedListener);
        mFirstGameNumber3.setOnItemSelectedListener(mItemSelectedListener);
        mFirstGameNumber4.setOnItemSelectedListener(mItemSelectedListener);
        mFirstGameNumber5.setOnItemSelectedListener(mItemSelectedListener);
        mFirstGameNumber6.setOnItemSelectedListener(mItemSelectedListener);

        mSecondGameNumber1.setOnItemSelectedListener(mItemSelectedListener);
        mSecondGameNumber2.setOnItemSelectedListener(mItemSelectedListener);
        mSecondGameNumber3.setOnItemSelectedListener(mItemSelectedListener);
        mSecondGameNumber4.setOnItemSelectedListener(mItemSelectedListener);
        mSecondGameNumber5.setOnItemSelectedListener(mItemSelectedListener);
        mSecondGameNumber6.setOnItemSelectedListener(mItemSelectedListener);

        mThirdGameNumber1.setOnItemSelectedListener(mItemSelectedListener);
        mThirdGameNumber2.setOnItemSelectedListener(mItemSelectedListener);
        mThirdGameNumber3.setOnItemSelectedListener(mItemSelectedListener);
        mThirdGameNumber4.setOnItemSelectedListener(mItemSelectedListener);
        mThirdGameNumber5.setOnItemSelectedListener(mItemSelectedListener);
        mThirdGameNumber6.setOnItemSelectedListener(mItemSelectedListener);

        mFourthGameNumber1.setOnItemSelectedListener(mItemSelectedListener);
        mFourthGameNumber2.setOnItemSelectedListener(mItemSelectedListener);
        mFourthGameNumber3.setOnItemSelectedListener(mItemSelectedListener);
        mFourthGameNumber4.setOnItemSelectedListener(mItemSelectedListener);
        mFourthGameNumber5.setOnItemSelectedListener(mItemSelectedListener);
        mFourthGameNumber6.setOnItemSelectedListener(mItemSelectedListener);

        mFifthGameNumber1.setOnItemSelectedListener(mItemSelectedListener);
        mFifthGameNumber2.setOnItemSelectedListener(mItemSelectedListener);
        mFifthGameNumber3.setOnItemSelectedListener(mItemSelectedListener);
        mFifthGameNumber4.setOnItemSelectedListener(mItemSelectedListener);
        mFifthGameNumber5.setOnItemSelectedListener(mItemSelectedListener);
        mFifthGameNumber6.setOnItemSelectedListener(mItemSelectedListener);
    }

    synchronized private void setRandomNumber(final Spinner gameNumber, final Map<Integer, Integer> gameNumbers, final long time, final Button button) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gameNumber.setSelection(getRandomNumber(gameNumbers));
                if (time == 500) {
                    button.setEnabled(true);
                }
            }
        }, time);
    }

    private void setButton() {
        mFirstRandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirstRandomButton.setEnabled(false);
                mFirstGameNumbers.clear();
                setRandomNumber(mFirstGameNumber1, mFirstGameNumbers, 0, mFirstRandomButton);
                setRandomNumber(mFirstGameNumber2, mFirstGameNumbers, 100, mFirstRandomButton);
                setRandomNumber(mFirstGameNumber3, mFirstGameNumbers, 200, mFirstRandomButton);
                setRandomNumber(mFirstGameNumber4, mFirstGameNumbers, 300, mFirstRandomButton);
                setRandomNumber(mFirstGameNumber5, mFirstGameNumbers, 400, mFirstRandomButton);
                setRandomNumber(mFirstGameNumber6, mFirstGameNumbers, 500, mFirstRandomButton);
            }
        });

        mSecondRandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSecondRandomButton.setEnabled(false);
                mSecondGameNumbers.clear();
                setRandomNumber(mSecondGameNumber1, mSecondGameNumbers, 0, mSecondRandomButton);
                setRandomNumber(mSecondGameNumber2, mSecondGameNumbers, 100, mSecondRandomButton);
                setRandomNumber(mSecondGameNumber3, mSecondGameNumbers, 200, mSecondRandomButton);
                setRandomNumber(mSecondGameNumber4, mSecondGameNumbers, 300, mSecondRandomButton);
                setRandomNumber(mSecondGameNumber5, mSecondGameNumbers, 400, mSecondRandomButton);
                setRandomNumber(mSecondGameNumber6, mSecondGameNumbers, 500, mSecondRandomButton);
            }
        });

        mThirdRandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mThirdRandomButton.setEnabled(false);
                mThirdGameNumbers.clear();
                setRandomNumber(mThirdGameNumber1, mThirdGameNumbers, 0, mThirdRandomButton);
                setRandomNumber(mThirdGameNumber2, mThirdGameNumbers, 100, mThirdRandomButton);
                setRandomNumber(mThirdGameNumber3, mThirdGameNumbers, 200, mThirdRandomButton);
                setRandomNumber(mThirdGameNumber4, mThirdGameNumbers, 300, mThirdRandomButton);
                setRandomNumber(mThirdGameNumber5, mThirdGameNumbers, 400, mThirdRandomButton);
                setRandomNumber(mThirdGameNumber6, mThirdGameNumbers, 500, mThirdRandomButton);
            }
        });

        mFourthRandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFourthRandomButton.setEnabled(false);
                mFourthGameNumbers.clear();
                setRandomNumber(mFourthGameNumber1, mFourthGameNumbers, 0, mFourthRandomButton);
                setRandomNumber(mFourthGameNumber2, mFourthGameNumbers, 100, mFourthRandomButton);
                setRandomNumber(mFourthGameNumber3, mFourthGameNumbers, 200, mFourthRandomButton);
                setRandomNumber(mFourthGameNumber4, mFourthGameNumbers, 300, mFourthRandomButton);
                setRandomNumber(mFourthGameNumber5, mFourthGameNumbers, 400, mFourthRandomButton);
                setRandomNumber(mFourthGameNumber6, mFourthGameNumbers, 500, mFourthRandomButton);
            }
        });

        mFifthRandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFifthRandomButton.setEnabled(false);
                mFifthGameNumbers.clear();
                setRandomNumber(mFifthGameNumber1, mFifthGameNumbers, 0, mFifthRandomButton);
                setRandomNumber(mFifthGameNumber2, mFifthGameNumbers, 100, mFifthRandomButton);
                setRandomNumber(mFifthGameNumber3, mFifthGameNumbers, 200, mFifthRandomButton);
                setRandomNumber(mFifthGameNumber4, mFifthGameNumbers, 300, mFifthRandomButton);
                setRandomNumber(mFifthGameNumber5, mFifthGameNumbers, 400, mFifthRandomButton);
                setRandomNumber(mFifthGameNumber6, mFifthGameNumbers, 500, mFifthRandomButton);
            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNumber(mFirstGameNumber1);
                resetNumber(mFirstGameNumber2);
                resetNumber(mFirstGameNumber3);
                resetNumber(mFirstGameNumber4);
                resetNumber(mFirstGameNumber5);
                resetNumber(mFirstGameNumber6);

                resetNumber(mSecondGameNumber1);
                resetNumber(mSecondGameNumber2);
                resetNumber(mSecondGameNumber3);
                resetNumber(mSecondGameNumber4);
                resetNumber(mSecondGameNumber5);
                resetNumber(mSecondGameNumber6);

                resetNumber(mThirdGameNumber1);
                resetNumber(mThirdGameNumber2);
                resetNumber(mThirdGameNumber3);
                resetNumber(mThirdGameNumber4);
                resetNumber(mThirdGameNumber5);
                resetNumber(mThirdGameNumber6);

                resetNumber(mFourthGameNumber1);
                resetNumber(mFourthGameNumber2);
                resetNumber(mFourthGameNumber3);
                resetNumber(mFourthGameNumber4);
                resetNumber(mFourthGameNumber5);
                resetNumber(mFourthGameNumber6);

                resetNumber(mFifthGameNumber1);
                resetNumber(mFifthGameNumber2);
                resetNumber(mFifthGameNumber3);
                resetNumber(mFifthGameNumber4);
                resetNumber(mFifthGameNumber5);
                resetNumber(mFifthGameNumber6);

                setWinNumber();
                mWinInfo.setText("win");
                mResultInfo.setText("result");
            }
        });

        mResultButton.setOnClickListener(new View.OnClickListener() {
            boolean isAllSelected;

            @Override
            public void onClick(View v) {
                Toast toast;
                isAllSelected = true;
                if (mFirstGameNumbers.containsValue(0)) {
                    isAllSelected = false;
                    toast = Toast.makeText(getApplicationContext(), "1번 게임 미선택 존재!!", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (mSecondGameNumbers.containsValue(0)) {
                    isAllSelected = false;
                    toast = Toast.makeText(getApplicationContext(), "2번 게임 미선택 존재!!", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (mThirdGameNumbers.containsValue(0)) {
                    isAllSelected = false;
                    toast = Toast.makeText(getApplicationContext(), "3번 게임 미선택 존재!!", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (mFourthGameNumbers.containsValue(0)) {
                    isAllSelected = false;
                    toast = Toast.makeText(getApplicationContext(), "4번 게임 미선택 존재!!", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (mFifthGameNumbers.containsValue(0)) {
                    isAllSelected = false;
                    toast = Toast.makeText(getApplicationContext(), "5번 게임 미선택 존재!!", Toast.LENGTH_SHORT);
                    toast.show();
                }

                if (isAllSelected) {
                    mWinInfo.setText("당첨번호 : " + mWinNumbers.get(0) + " " + mWinNumbers.get(1) + " " + mWinNumbers.get(2) + " " + mWinNumbers.get(3)
                            + " " + mWinNumbers.get(4) + " " + mWinNumbers.get(5) + " 보너스 : " + mBonusNum);
                    mResultText = new StringBuilder("");
                    isWin(mFirstGameNumbers, 1);
                    isWin(mSecondGameNumbers, 2);
                    isWin(mThirdGameNumbers, 3);
                    isWin(mFourthGameNumbers, 4);
                    isWin(mFifthGameNumbers, 5);
                }
            }
        });
    }

    private void onFirstGameItemSelected(AdapterView<?> parent, int position) {
        int selectedNumber = Integer.parseInt((String) parent.getItemAtPosition(position));
        switch (parent.getId()) {
            case R.id.first_number1:
                if (isDuplication(mFirstGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFirstGameNumber1, mFirstGameNumbers);
                } else {
                    mFirstGameNumbers.put(0, selectedNumber);
                }
                break;
            case R.id.first_number2:
                if (isDuplication(mFirstGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFirstGameNumber2, mFirstGameNumbers);
                } else {
                    mFirstGameNumbers.put(1, selectedNumber);
                }
                break;
            case R.id.first_number3:
                if (isDuplication(mFirstGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFirstGameNumber3, mFirstGameNumbers);
                } else {
                    mFirstGameNumbers.put(2, selectedNumber);
                }
                break;
            case R.id.first_number4:
                if (isDuplication(mFirstGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFirstGameNumber4, mFirstGameNumbers);
                } else {
                    mFirstGameNumbers.put(3, selectedNumber);
                }
                break;
            case R.id.first_number5:
                if (isDuplication(mFirstGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFirstGameNumber5, mFirstGameNumbers);
                } else {
                    mFirstGameNumbers.put(4, selectedNumber);
                }
                break;
            case R.id.first_number6:
                if (isDuplication(mFirstGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFirstGameNumber6, mFirstGameNumbers);
                } else {
                    mFirstGameNumbers.put(5, selectedNumber);
                }
                break;
        }
    }

    private void onSecondGameItemSelected(AdapterView<?> parent, int position) {
        int selectedNumber = Integer.parseInt((String) parent.getItemAtPosition(position));
        switch (parent.getId()) {
            case R.id.second_number1:
                if (isDuplication(mSecondGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mSecondGameNumber1, mSecondGameNumbers);
                } else {
                    mSecondGameNumbers.put(0, selectedNumber);
                }
                break;
            case R.id.second_number2:
                if (isDuplication(mSecondGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mSecondGameNumber2, mSecondGameNumbers);
                } else {
                    mSecondGameNumbers.put(1, selectedNumber);
                }
                break;
            case R.id.second_number3:
                if (isDuplication(mSecondGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mSecondGameNumber3, mSecondGameNumbers);
                } else {
                    mSecondGameNumbers.put(2, selectedNumber);
                }
                break;
            case R.id.second_number4:
                if (isDuplication(mSecondGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mSecondGameNumber4, mSecondGameNumbers);
                } else {
                    mSecondGameNumbers.put(3, selectedNumber);
                }
                break;
            case R.id.second_number5:
                if (isDuplication(mSecondGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mSecondGameNumber5, mSecondGameNumbers);
                } else {
                    mSecondGameNumbers.put(4, selectedNumber);
                }
                break;
            case R.id.second_number6:
                if (isDuplication(mSecondGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mSecondGameNumber6, mSecondGameNumbers);
                } else {
                    mSecondGameNumbers.put(5, selectedNumber);
                }
                break;
        }
    }

    private void onThirdGameItemSelected(AdapterView<?> parent, int position) {
        int selectedNumber = Integer.parseInt((String) parent.getItemAtPosition(position));
        switch (parent.getId()) {
            case R.id.third_number1:
                if (isDuplication(mThirdGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mThirdGameNumber1, mThirdGameNumbers);
                } else {
                    mThirdGameNumbers.put(0, selectedNumber);
                }
                break;
            case R.id.third_number2:
                if (isDuplication(mThirdGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mThirdGameNumber2, mThirdGameNumbers);
                } else {
                    mThirdGameNumbers.put(1, selectedNumber);
                }
                break;
            case R.id.third_number3:
                if (isDuplication(mThirdGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mThirdGameNumber3, mThirdGameNumbers);
                } else {
                    mThirdGameNumbers.put(2, selectedNumber);
                }
                break;
            case R.id.third_number4:
                if (isDuplication(mThirdGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mThirdGameNumber4, mThirdGameNumbers);
                } else {
                    mThirdGameNumbers.put(3, selectedNumber);
                }
                break;
            case R.id.third_number5:
                if (isDuplication(mThirdGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mThirdGameNumber5, mThirdGameNumbers);
                } else {
                    mThirdGameNumbers.put(4, selectedNumber);
                }
                break;
            case R.id.third_number6:
                if (isDuplication(mThirdGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mThirdGameNumber6, mThirdGameNumbers);
                } else {
                    mThirdGameNumbers.put(5, selectedNumber);
                }
                break;
        }
    }

    private void onFourthGameItemSelected(AdapterView<?> parent, int position) {
        int selectedNumber = Integer.parseInt((String) parent.getItemAtPosition(position));
        switch (parent.getId()) {
            case R.id.fourth_number1:
                if (isDuplication(mFourthGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFourthGameNumber1, mFourthGameNumbers);
                } else {
                    mFourthGameNumbers.put(0, selectedNumber);
                }
                break;
            case R.id.fourth_number2:
                if (isDuplication(mFourthGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFourthGameNumber2, mFourthGameNumbers);
                } else {
                    mFourthGameNumbers.put(1, selectedNumber);
                }
                break;
            case R.id.fourth_number3:
                if (isDuplication(mFourthGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFourthGameNumber3, mFourthGameNumbers);
                } else {
                    mFourthGameNumbers.put(2, selectedNumber);
                }
                break;
            case R.id.fourth_number4:
                if (isDuplication(mFourthGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFourthGameNumber4, mFourthGameNumbers);
                } else {
                    mFourthGameNumbers.put(3, selectedNumber);
                }
                break;
            case R.id.fourth_number5:
                if (isDuplication(mFourthGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFourthGameNumber5, mFourthGameNumbers);
                } else {
                    mFourthGameNumbers.put(4, selectedNumber);
                }
                break;
            case R.id.fourth_number6:
                if (isDuplication(mFourthGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFourthGameNumber6, mFourthGameNumbers);
                } else {
                    mFourthGameNumbers.put(5, selectedNumber);
                }
                break;
        }
    }

    private void onFifthGameItemSelected(AdapterView<?> parent, int position) {
        int selectedNumber = Integer.parseInt((String) parent.getItemAtPosition(position));
        switch (parent.getId()) {
            case R.id.fifth_number1:
                if (isDuplication(mFifthGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFifthGameNumber1, mFifthGameNumbers);
                } else {
                    mFifthGameNumbers.put(0, selectedNumber);
                }
                break;
            case R.id.fifth_number2:
                if (isDuplication(mFifthGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFifthGameNumber2, mFifthGameNumbers);
                } else {
                    mFifthGameNumbers.put(1, selectedNumber);
                }
                break;
            case R.id.fifth_number3:
                if (isDuplication(mFifthGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFifthGameNumber3, mFifthGameNumbers);
                } else {
                    mFifthGameNumbers.put(2, selectedNumber);
                }
                break;
            case R.id.fifth_number4:
                if (isDuplication(mFifthGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFifthGameNumber4, mFifthGameNumbers);
                } else {
                    mFifthGameNumbers.put(3, selectedNumber);
                }
                break;
            case R.id.fifth_number5:
                if (isDuplication(mFifthGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFifthGameNumber5, mFifthGameNumbers);
                } else {
                    mFifthGameNumbers.put(4, selectedNumber);
                }
                break;
            case R.id.fifth_number6:
                if (isDuplication(mFifthGameNumbers, selectedNumber)) {
                    showDuplicationDialog(mFifthGameNumber6, mFifthGameNumbers);
                } else {
                    mFifthGameNumbers.put(5, selectedNumber);
                }
                break;
        }
    }

    private void resetNumber(final Spinner gameNumber) {
        gameNumber.setSelection(0);
    }

    private void showDuplicationDialog(final Spinner gameNumber, final Map<Integer, Integer> gameNumbers) {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("알림")
                .setMessage("이미 선택한 숫자 입니다.")
                .setCancelable(false)
                .setPositiveButton("자동 선택",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                gameNumber.setSelection(getRandomNumber(gameNumbers));
                            }
                        })
                .setNegativeButton("다시 선택", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gameNumber.setSelection(0);
                    }
                });
        alert.show();
    }

    private boolean isDuplication(Map<Integer, Integer> gameNumbers, int selectedNumber) {
        return gameNumbers.containsValue(selectedNumber) && (selectedNumber != 0);
    }

    private int getRandomNumber(Map<Integer, Integer> gameNumbers) {
        Random generator = new Random();
        int num = generator.nextInt(45) + 1;
        while (isDuplication(gameNumbers, num)) {
            num = generator.nextInt(45) + 1;
        }
        return num;
    }

    private void setWinNumber() {
        for (int i = 0; i < 6; i++) {
            mWinNumbers.put(i, getRandomNumber(mWinNumbers));
        }
        mBonusNum = getRandomNumber(mWinNumbers);
    }

    private int resultWin(Map<Integer, Integer> numbers) {
        int count = 7;
        for (int i = 0; i < 6; i++) {
            if (mWinNumbers.containsValue(numbers.get(i))) {
                count--;
            }
        }

        if (count == 2) {
            if (!numbers.containsValue(mBonusNum)) {
                count++;
            }
        }
        return count;
    }

    private void isWin(Map<Integer, Integer> gameNumbers, int gameNum) {
        if (resultWin(gameNumbers) > 5) {
            mResultText.append(gameNum + "번 꽝! ");
        } else {
            mResultText.append(gameNum + "번 " + resultWin(gameNumbers) + "등! ");
        }

        mResultInfo.setText(mResultText);
    }
}