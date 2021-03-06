package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.BoxModel;
import view.MainPanelView;

public class KeysEvent implements KeyListener {
	public static int flag=0;
	public String userInput;
	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 长时间按住键
		userInput = "" + e.getKeyChar();
		if (userInput.equals("A")) {
			TetrisController.setSleepTime(50);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("in keyreleased");
		// 松开某个键
		 userInput = "" + e.getKeyChar();

		switch (userInput) {
		case "S":
			startGame();
			break;
		case "E":
			exitGame();
			break;
		case "P":
			pauseGame();
			break;
		case "Q":
			quitRound();
			break;
		case "R":
			reStartRound();
			break;
		case "B":
			moveLeftBox();
			break;
		case "M":
			moveRightBox();
			break;
		case "H":
			clockwiseBox();
			break;
		case "N":
			counterclockwiseBox();
			break;
		case "A":
			recoverSpeed();
			break;
		default:
			break;
		}

		System.out.println("userInput" + userInput);
	}

	public void recoverSpeed() {
		System.out.println("in recove");
		// 松开按键"A"后恢复原速度
		TetrisController.setSleepTime(1100);
		flag=6;
	}

	public void startGame() {
		// 修改tetriscontroller里面的一个控制开关，让游戏的方块可以更改坐标
		TetrisController.setPause(false);
	}

	// 重新开一轮游戏
	public void reStartRound() {
		TetrisController.setStart(true);
		TetrisController.setPause(true);
		TetrisController.getMainJFrame().setVisible(false);// 让以前的窗口被隐藏
		TetrisController.setMainJFrame(new MainPanelView(TetrisController.tetris.createTp()));
		TetrisController.getMainJFrame().repaint();
	}

	public void pauseGame() {
		TetrisController.setPause(true);
	}

	public void quitRound() {
		TetrisController.setStart(false);
	}

	public void exitGame() {
		System.exit(0);
	}

	public void moveLeftBox() {
		BoxModel tempBox = TetrisController.mainJFrame.getTp().getBox();
		int[] changeX = new int[4];
		boolean f = true;
		for (int m = 0; m < 4; m++) {
			// 检查是否有一个方块超过左边界
			if ((tempBox.getX()[m] - 1) < 0) {
				f = false;
				break;
			} else {
				// 检查左侧是否有一个方块
				for (int n = 0; n < 4; n++) {
					if (TetrisController.mainJFrame.getTp().getPositioinFlag()[tempBox.getX()[m] - 1][n][0] == 1) {
						f = false;
						break;
					}
				}
			}
		}
		// 如果检查发现下一步移动既不会超过左边界又不会碰到已有标记方格则左移积木
		if (f) {
			for (int m = 0; m < 4; m++) {
				changeX[m] = tempBox.getX()[m] - 1;
			}
			TetrisController.mainJFrame.getTp().getBox().setX(changeX);
			TetrisController.setMoveCols(true);
			TetrisController.mainJFrame.repaint();// 每次左右或旋转移动后刷新界面，立刻显示
		}
		flag=2;
	}

	public void moveRightBox() {
		BoxModel tempBox = TetrisController.mainJFrame.getTp().getBox();
		int[] changeX = new int[4];
		boolean f = true;
		for (int m = 0; m < 4; m++) {
			// 检查是否有一个方块超过右边界
			if ((tempBox.getX()[m] + 1) > 12) {
				f = false;
				break;
			} else {
				// 检查右侧是否有一个方块
				for (int n = 0; n < 4; n++) {
					if (TetrisController.mainJFrame.getTp().getPositioinFlag()[tempBox.getX()[m] + 1][n][0] == 1) {
						f = false;
						break;
					}
				}
			}
		}
		// 如果检查发现下一步移动既不会超过右边界又不会碰到已有标记方格则右移积木
		if (f) {
			for (int m = 0; m < 4; m++) {
				changeX[m] = tempBox.getX()[m] + 1;
			}
			TetrisController.mainJFrame.getTp().getBox().setX(changeX);
			TetrisController.setMoveCols(true);
			TetrisController.mainJFrame.repaint();// 每次左右或旋转移动后刷新界面，立刻显示
		}
		flag=3;
	}

	public void clockwiseBox() {
		int currentAngle = TetrisController.mainJFrame.getTp().getBox().getCurrentAngle();
		flag=4;
		if (currentAngle == 0 || currentAngle == 360) {
			TetrisController.mainJFrame.getTp().getBox().setAngle(90);
			TetrisController.mainJFrame.getTp().getBox().setCurrentAngle(90);
		} else if (currentAngle == 90) {
			TetrisController.mainJFrame.getTp().getBox().setAngle(180);
			TetrisController.mainJFrame.getTp().getBox().setCurrentAngle(180);
		} else if (currentAngle == 180) {
			TetrisController.mainJFrame.getTp().getBox().setAngle(270);
			TetrisController.mainJFrame.getTp().getBox().setCurrentAngle(270);
		} else if (currentAngle == 270) {
			TetrisController.mainJFrame.getTp().getBox().setAngle(360);
			TetrisController.mainJFrame.getTp().getBox().setCurrentAngle(360);
		}
		
	}

	public void counterclockwiseBox() {
		int currentAngle = TetrisController.mainJFrame.getTp().getBox().getCurrentAngle();
		flag=5;
		if (currentAngle == 0 || currentAngle == 360) {
			TetrisController.mainJFrame.getTp().getBox().setAngle(270);
			TetrisController.mainJFrame.getTp().getBox().setCurrentAngle(270);
		} else if (currentAngle == 90) {
			TetrisController.mainJFrame.getTp().getBox().setAngle(360);
			TetrisController.mainJFrame.getTp().getBox().setCurrentAngle(360);
		} else if (currentAngle == 180) {
			TetrisController.mainJFrame.getTp().getBox().setAngle(90);
			TetrisController.mainJFrame.getTp().getBox().setCurrentAngle(90);
		} else if (currentAngle == 270) {
			TetrisController.mainJFrame.getTp().getBox().setAngle(180);
			TetrisController.mainJFrame.getTp().getBox().setCurrentAngle(180);
		}
	}
}
