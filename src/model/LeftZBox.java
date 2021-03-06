package model;

import java.awt.Color;

public class LeftZBox extends BoxModel {

	public LeftZBox() {
		int[] x = { 5, 6, 6, 7 };
		int[] y = { -1, -1, 0, 0 };
		setX(x);
		setY(y);
		setStatus(1);
		setAngle(0);
		setBaseColor(Color.YELLOW);
	}

	@Override
	public void update90NextXY(int x1, int y1) {
		int[] x = new int[4];
		int[] y = new int[4];
		x[1] = x1;
		y[1] = y1;
		x[0] = x[1];
		y[0] = y[1] - 1;
		x[2] = x[1] - 1;
		y[2] = y[1];
		x[3] = x[2];
		y[3] = y[2] + 1;
		setX(x);
		setY(y);

		// 改过当前坐标后，重新定义下一个坐标
		int[] tNextX = new int[4];
		int[] tNextY = new int[4];

		for (int i = 0; i < 4; i++) {
			tNextX[i] = this.getX()[i];
			tNextY[i] = this.getY()[i] + 1;
		}
		this.setNextX(tNextX);
		this.setNextY(tNextY);
		setAngle(0);
	}

@Override
	public void update180NextXY(int x1, int y1) {
		int[] x = new int[4];
		int[] y = new int[4];
		x[1] = x1;
		y[1] = y1;
		x[0] = x[1] + 1;
		y[0] = y[1];
		x[2] = x[1];
		y[2] = y[1] - 1;
		x[3] = x[2] - 1;
		y[3] = y[2];
		setX(x);
		setY(y);

		// 改过当前坐标后，重新定义下一个坐标
		int[] tNextX = new int[4];
		int[] tNextY = new int[4];

		for (int i = 0; i < 4; i++) {
			tNextX[i] = this.getX()[i];
			tNextY[i] = this.getY()[i] + 1;
		}
		this.setNextX(tNextX);
		this.setNextY(tNextY);
		setAngle(0);
	}

@Override
	public void update270NextXY(int x1, int y1) {
		int[] x = new int[4];
		int[] y = new int[4];
		x[1] = x1;
		y[1] = y1;
		x[0] = x[1];
		y[0] = y[1] - 1;
		x[2] = x[1] - 1;
		y[2] = y[1];
		x[3] = x[2];
		y[3] = y[2] + 1;
		setX(x);
		setY(y);

		// 改过当前坐标后，重新定义下一个坐标
		int[] tNextX = new int[4];
		int[] tNextY = new int[4];

		for (int i = 0; i < 4; i++) {
			tNextX[i] = this.getX()[i];
			tNextY[i] = this.getY()[i] + 1;
		}
		this.setNextX(tNextX);
		this.setNextY(tNextY);
		setAngle(0);
	}

@Override
	public void update360NextXY(int x1, int y1) {
		int[] x = new int[4];
		int[] y = new int[4];
		x[1] = x1;
		y[1] = y1;
		x[0] = x[1] + 1;
		y[0] = y[1];
		x[2] = x[1];
		y[2] = y[1] - 1;
		x[3] = x[2] - 1;
		y[3] = y[2];
		setX(x);
		setY(y);

		// 改过当前坐标后，重新定义下一个坐标
		int[] tNextX = new int[4];
		int[] tNextY = new int[4];

		for (int i = 0; i < 4; i++) {
			tNextX[i] = this.getX()[i];
			tNextY[i] = this.getY()[i] + 1;
		}
		this.setNextX(tNextX);
		this.setNextY(tNextY);
		setAngle(0);
	}

}
