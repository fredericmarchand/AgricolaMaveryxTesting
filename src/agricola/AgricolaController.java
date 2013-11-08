package agricola;

//Author: Robert Souter 100802267
//Supervisor: Jean-Pierre Corriveau Ph.D.
//Carleton University
//School of Computer Science
//COMP 4905
//Winter 2013

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings({ "unused", "serial" })
public class AgricolaController extends JFrame implements MouseListener,
		ActionListener {

	private Player[] players;
	private FarmView view;
	private JButton[][] b;
	private Space[][][] farm;
	private JButton b_room, b_start, b_grain, b_field, b_stable, b_day, b_wood,
			b_clay, b_reed, b_food, b_sheep, b_sow, b_fences, b_improve,
			b_stone, b_growth, b_renov, b_boar, b_vege, b_cattle, b_stone2,
			b_growth2, b_fieldsow, b_renov2, b3_clay, b3_2wood, b3_resource,
			b3_resource2, b4_wood, b4_2clay, b4_2wood, b4_food, b4_resource,
			b4_3resource, b5_4wood, b5_3clay, b5_roomfood, b5_reed, b5_animals,
			b5_resource, b_finish;
	private JRadioButtonMenuItem mplayer1, mplayer2, mplayer3, mplayer4, mplayer5;
	
	private Space seat_text;
	private int game, num_players;
	private int turn, wood, clay, reed, food, sheep, stone, stone2, boar,
			cattle, clay_3p, wood2_3p, wood_4p, wood2_4p, clay2_4p, food_4p,
			wood4_5p, clay3_5p, food_5p, reed_5p;
	private int cur_player, start_player, view_player;
	private boolean wField, wRoom, wStableRoom, wStable, wRoom2, wSow,
			wFieldSow, wFences, wFences2, extraFences, wSheep, wBoar, wCattle,
			wField2, wRoom5p;
	private int fireplace_num, hearth_num;
	private boolean well, clay_oven, stone_oven, wood_converter,
			clay_converter, reed_converter;

	public AgricolaController(int numplayers) {
		fireplace_num = 2;
		hearth_num = 2;
		well = true;
		clay_oven = true;
		stone_oven = true;
		wood_converter = true;
		clay_converter = true;
		reed_converter = true;
		extraFences = false;
		wFences2 = false;

		players = new Player[numplayers];
		farm = new Space[5][7][11];

		view = new FarmView();

		for (int i = 0; i < numplayers; ++i) {
			num_players++;
			players[i] = new Player();
		}
		view.setPlayerMenu(num_players);

		for (int r = 0; r < 7; r++) {
			for (int col = 0; col < 11; col++) {
				farm[0][r][col] = new Space();
				if (r % 2 == 1 && col % 2 == 1) {
					farm[0][r][col].setSquare();
					if ((col == 1 && r == 3) || (col == 1 && r == 5))
						farm[0][r][col].setType('w');
				}
				if (r % 2 == 0 && col % 2 == 0)
					farm[0][r][col].setValid();

			}

		}

		mplayer1 = view.getPlayer1();
		mplayer1.addActionListener(this);

		// initializing farms

		if (num_players > 1) {
			mplayer2 = view.getPlayer2();
			mplayer2.addActionListener(this);

			for (int r = 0; r < 7; r++) {
				for (int col = 0; col < 11; col++) {
					farm[1][r][col] = new Space();
					if (r % 2 == 1 && col % 2 == 1) {
						farm[1][r][col].setSquare();
						if ((col == 1 && r == 3) || (col == 1 && r == 5))
							farm[1][r][col].setType('w');
					}
					if (r % 2 == 0 && col % 2 == 0)
						farm[1][r][col].setValid();

				}

			}

		}
		if (num_players > 2) {
			mplayer3 = view.getPlayer3();
			mplayer3.addActionListener(this);

			for (int r = 0; r < 7; r++) {
				for (int col = 0; col < 11; col++) {
					farm[2][r][col] = new Space();
					if (r % 2 == 1 && col % 2 == 1) {
						farm[2][r][col].setSquare();
						if ((col == 1 && r == 3) || (col == 1 && r == 5))
							farm[2][r][col].setType('w');
					}
					if (r % 2 == 0 && col % 2 == 0)
						farm[2][r][col].setValid();

				}

			}

		}
		if (num_players > 3) {
			mplayer4 = view.getPlayer4();
			mplayer4.addActionListener(this);

			for (int r = 0; r < 7; r++) {
				for (int col = 0; col < 11; col++) {
					farm[3][r][col] = new Space();
					if (r % 2 == 1 && col % 2 == 1) {
						farm[3][r][col].setSquare();
						if ((col == 1 && r == 3) || (col == 1 && r == 5))
							farm[3][r][col].setType('w');
					}
					if (r % 2 == 0 && col % 2 == 0)
						farm[3][r][col].setValid();

				}

			}

		}
		if (num_players > 4) {
			mplayer5 = view.getPlayer5();
			mplayer5.addActionListener(this);
			for (int r = 0; r < 7; r++) {
				for (int col = 0; col < 11; col++) {
					farm[4][r][col] = new Space();
					if (r % 2 == 1 && col % 2 == 1) {
						farm[4][r][col].setSquare();
						if ((col == 1 && r == 3) || (col == 1 && r == 5))
							farm[4][r][col].setType('w');
					}
					if (r % 2 == 0 && col % 2 == 0)
						farm[4][r][col].setValid();

				}

			}

		}

		cur_player = 0;
		start_player = 0;
		view_player = 0;
		b = view.getButtons();
		game = 1;
		if (num_players == 1) {
			wood = 2;
			view.getGameTexts()[1].setText(Integer.toString(wood));

		} else
			wood = 3;
		clay = 1;
		reed = 1;
		food = 1;
		sheep = 1;
		stone = 1;
		stone2 = 1;
		boar = 1;
		cattle = 1;
		turn = 1;
		// start variables for the game values, the wood space either gives 2 or
		// 3 depending on if it is a solo game

		// extra button initializations for 3-5 player games
		if (num_players == 3) {
			clay_3p = 1;
			wood2_3p = 1;

			view.get3Actions()[0].setVisible(true);
			view.get3Actions()[1].setVisible(true);
			view.get3Actions()[2].setVisible(true);
			view.get3Actions()[3].setVisible(true);

			b3_clay = view.get3Actions()[0];
			b3_clay.addActionListener(this);

			b3_2wood = view.get3Actions()[1];
			b3_2wood.addActionListener(this);

			b3_resource = view.get3Actions()[2];
			b3_resource.addActionListener(this);

			b3_resource2 = view.get3Actions()[3];
			b3_resource2.addActionListener(this);

			view.get3Texts()[0].setVisible(true);
			view.get3Texts()[1].setVisible(true);

		}

		else if (num_players == 4) {
			wood_4p = 1;
			wood2_4p = 2;
			clay2_4p = 2;
			food_4p = 1;

			view.get4Actions()[0].setVisible(true);
			view.get4Actions()[1].setVisible(true);
			view.get4Actions()[2].setVisible(true);
			view.get4Actions()[3].setVisible(true);
			view.get4Actions()[4].setVisible(true);
			view.get4Actions()[5].setVisible(true);

			b4_wood = view.get4Actions()[0];
			b4_wood.addActionListener(this);

			b4_2clay = view.get4Actions()[1];
			b4_2clay.addActionListener(this);

			b4_2wood = view.get4Actions()[2];
			b4_2wood.addActionListener(this);

			b4_food = view.get4Actions()[3];
			b4_food.addActionListener(this);

			b4_resource = view.get4Actions()[4];
			b4_resource.addActionListener(this);

			b4_3resource = view.get4Actions()[5];
			b4_3resource.addActionListener(this);

			view.get4Texts()[0].setVisible(true);
			view.get4Texts()[1].setVisible(true);
			view.get4Texts()[2].setVisible(true);
			view.get4Texts()[3].setVisible(true);
		} else if (num_players == 5) {
			wood4_5p = 4;
			clay3_5p = 3;
			food_5p = 1;
			reed_5p = 1;

			view.get5Actions()[0].setVisible(true);
			view.get5Actions()[1].setVisible(true);
			view.get5Actions()[2].setVisible(true);
			view.get5Actions()[3].setVisible(true);
			view.get5Actions()[4].setVisible(true);
			view.get5Actions()[5].setVisible(true);

			b5_4wood = view.get5Actions()[0];
			b5_4wood.addActionListener(this);

			b5_3clay = view.get5Actions()[1];
			b5_3clay.addActionListener(this);

			b5_roomfood = view.get5Actions()[2];
			b5_roomfood.addActionListener(this);

			b5_reed = view.get5Actions()[3];
			b5_reed.addActionListener(this);

			b5_animals = view.get5Actions()[4];
			b5_animals.addActionListener(this);

			b5_resource = view.get5Actions()[5];
			b5_resource.addActionListener(this);

			view.get5Texts()[0].setVisible(true);
			view.get5Texts()[1].setVisible(true);
			view.get5Texts()[2].setVisible(true);
			view.get5Texts()[3].setVisible(true);

		}

		// all button initilizations
		b_room = view.getActions()[0];
		b_room.addActionListener(this);

		b_start = view.getActions()[1];
		b_start.addActionListener(this);

		b_grain = view.getActions()[2];
		b_grain.addActionListener(this);

		b_field = view.getActions()[3];
		b_field.addActionListener(this);

		b_stable = view.getActions()[4];
		b_stable.addActionListener(this);

		b_day = view.getActions()[5];
		b_day.addActionListener(this);

		b_wood = view.getActions()[6];
		b_wood.addActionListener(this);

		b_clay = view.getActions()[7];
		b_clay.addActionListener(this);

		b_reed = view.getActions()[8];
		b_reed.addActionListener(this);

		b_food = view.getActions()[9];
		b_food.addActionListener(this);

		b_sheep = view.getActions()[10];
		b_sheep.addActionListener(this);

		b_sow = view.getActions()[11];
		b_sow.setVisible(false);
		b_sow.addActionListener(this);

		b_fences = view.getActions()[12];
		b_fences.setVisible(false);
		b_fences.addActionListener(this);

		b_improve = view.getActions()[13];
		b_improve.setVisible(false);
		b_improve.addActionListener(this);

		b_stone = view.getActions()[14];
		b_stone.setVisible(false);
		b_stone.addActionListener(this);

		b_growth = view.getActions()[15];
		b_growth.setVisible(false);
		b_growth.addActionListener(this);

		b_renov = view.getActions()[16];
		b_renov.setVisible(false);
		b_renov.addActionListener(this);

		b_boar = view.getActions()[17];
		b_boar.setVisible(false);
		b_boar.addActionListener(this);

		b_vege = view.getActions()[18];
		b_vege.setVisible(false);
		b_vege.addActionListener(this);

		b_cattle = view.getActions()[19];
		b_cattle.setVisible(false);
		b_cattle.addActionListener(this);

		b_stone2 = view.getActions()[20];
		b_stone2.setVisible(false);
		b_stone2.addActionListener(this);

		b_growth2 = view.getActions()[21];
		b_growth2.setVisible(false);
		b_growth2.addActionListener(this);

		b_fieldsow = view.getActions()[22];
		b_fieldsow.setVisible(false);
		b_fieldsow.addActionListener(this);

		b_renov2 = view.getActions()[23];
		b_renov2.setVisible(false);
		b_renov2.addActionListener(this);

		b_finish = view.getActions()[24];
		b_finish.addActionListener(this);
		b_finish.setVisible(false);

		
		view.setVisible(true);
		view.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// farm buttons
		for (int r = 0; r < 7; r++) {
			for (int col = 0; col < 11; col++) {
				if (b[r][col].isEnabled()) {
					b[r][col].addActionListener(this);
					b[r][col].addMouseListener(this);
				}
			}
		}
	}

	/*public AgricolaController() {
		num_players = 0;
		fireplace_num = 2;
		hearth_num = 2;
		well = true;
		clay_oven = true;
		stone_oven = true;
		wood_converter = true;
		clay_converter = true;
		reed_converter = true;
		extraFences = false;
		wFences2 = false;

		players = new Player[5];
		farm = new Space[5][7][11];

		view = new FarmView();

		// initializing variables and asking the user how many players are
		// playing and of what type
		Object[] possibilities = { "Human", "Computer - Normal",
				"Computer - Hard" };
		String s = (String) JOptionPane.showInputDialog(null,
				"Please Select Player 1", "Setup Game",
				JOptionPane.PLAIN_MESSAGE, null, possibilities, "Human");
		num_players++;
		players[0] = new Player();
		if (s.equals("Computer - Normal"))
			players[0].setComputer(false);
		else if (s.equals("Computer - Hard"))
			players[0].setComputer(true);

		Object[] possibilities2 = { "Human", "Computer - Normal",
				"Computer - Hard", "No More Players" };

		s = (String) JOptionPane.showInputDialog(null,
				"Please Select Player 2", "Setup Game",
				JOptionPane.PLAIN_MESSAGE, null, possibilities2, "Human");
		if (!s.equals("No More Players")) {
			players[1] = new Player();
			num_players++;
			if (s.equals("Computer - Normal"))
				players[1].setComputer(false);
			else if (s.equals("Computer - Hard"))
				players[1].setComputer(true);

			s = (String) JOptionPane.showInputDialog(null,
					"Please Select Player 3", "Setup Game",
					JOptionPane.PLAIN_MESSAGE, null, possibilities2, "Human");
			if (!s.equals("No More Players")) {
				players[2] = new Player();
				num_players++;
				if (s.equals("Computer - Normal"))
					players[2].setComputer(false);
				else if (s.equals("Computer - Hard"))
					players[2].setComputer(true);

				s = (String) JOptionPane.showInputDialog(null,
						"Please Select Player 4", "Setup Game",
						JOptionPane.PLAIN_MESSAGE, null, possibilities2,
						"Human");
				if (!s.equals("No More Players")) {
					players[3] = new Player();
					num_players++;
					if (s.equals("Computer - Normal"))
						players[3].setComputer(false);
					else if (s.equals("Computer - Hard"))
						players[3].setComputer(true);

					s = (String) JOptionPane.showInputDialog(null,
							"Please Select Player 5", "Setup Game",
							JOptionPane.PLAIN_MESSAGE, null, possibilities2,
							"Human");
					if (!s.equals("No More Players")) {
						players[4] = new Player();
						num_players++;
						if (s.equals("Computer - Normal"))
							players[4].setComputer(false);
						else if (s.equals("Computer - Hard"))
							players[4].setComputer(true);

					}
				}
			}
		}

		view.setPlayerMenu(num_players);

		for (int r = 0; r < 7; r++) {
			for (int col = 0; col < 11; col++) {
				farm[0][r][col] = new Space();
				if (r % 2 == 1 && col % 2 == 1) {
					farm[0][r][col].setSquare();
					if ((col == 1 && r == 3) || (col == 1 && r == 5))
						farm[0][r][col].setType('w');
				}
				if (r % 2 == 0 && col % 2 == 0)
					farm[0][r][col].setValid();

			}

		}

		mplayer1 = view.getPlayer1();
		mplayer1.addActionListener(this);

		// initializing farms

		if (num_players > 1) {
			mplayer2 = view.getPlayer2();
			mplayer2.addActionListener(this);

			for (int r = 0; r < 7; r++) {
				for (int col = 0; col < 11; col++) {
					farm[1][r][col] = new Space();
					if (r % 2 == 1 && col % 2 == 1) {
						farm[1][r][col].setSquare();
						if ((col == 1 && r == 3) || (col == 1 && r == 5))
							farm[1][r][col].setType('w');
					}
					if (r % 2 == 0 && col % 2 == 0)
						farm[1][r][col].setValid();

				}

			}

		}
		if (num_players > 2) {
			mplayer3 = view.getPlayer3();
			mplayer3.addActionListener(this);

			for (int r = 0; r < 7; r++) {
				for (int col = 0; col < 11; col++) {
					farm[2][r][col] = new Space();
					if (r % 2 == 1 && col % 2 == 1) {
						farm[2][r][col].setSquare();
						if ((col == 1 && r == 3) || (col == 1 && r == 5))
							farm[2][r][col].setType('w');
					}
					if (r % 2 == 0 && col % 2 == 0)
						farm[2][r][col].setValid();

				}

			}

		}
		if (num_players > 3) {
			mplayer4 = view.getPlayer4();
			mplayer4.addActionListener(this);

			for (int r = 0; r < 7; r++) {
				for (int col = 0; col < 11; col++) {
					farm[3][r][col] = new Space();
					if (r % 2 == 1 && col % 2 == 1) {
						farm[3][r][col].setSquare();
						if ((col == 1 && r == 3) || (col == 1 && r == 5))
							farm[3][r][col].setType('w');
					}
					if (r % 2 == 0 && col % 2 == 0)
						farm[3][r][col].setValid();

				}

			}

		}
		if (num_players > 4) {
			mplayer5 = view.getPlayer5();
			mplayer5.addActionListener(this);
			for (int r = 0; r < 7; r++) {
				for (int col = 0; col < 11; col++) {
					farm[4][r][col] = new Space();
					if (r % 2 == 1 && col % 2 == 1) {
						farm[4][r][col].setSquare();
						if ((col == 1 && r == 3) || (col == 1 && r == 5))
							farm[4][r][col].setType('w');
					}
					if (r % 2 == 0 && col % 2 == 0)
						farm[4][r][col].setValid();

				}

			}

		}

		cur_player = 0;
		start_player = 0;
		view_player = 0;
		b = view.getButtons();
		game = 1;
		if (num_players == 1) {
			wood = 2;
			view.getGameTexts()[1].setText(Integer.toString(wood));

		} else
			wood = 3;
		clay = 1;
		reed = 1;
		food = 1;
		sheep = 1;
		stone = 1;
		stone2 = 1;
		boar = 1;
		cattle = 1;
		turn = 1;
		// start variables for the game values, the wood space either gives 2 or
		// 3 depending on if it is a solo game

		// extra button initializations for 3-5 player games
		if (num_players == 3) {
			clay_3p = 1;
			wood2_3p = 1;

			view.get3Actions()[0].setVisible(true);
			view.get3Actions()[1].setVisible(true);
			view.get3Actions()[2].setVisible(true);
			view.get3Actions()[3].setVisible(true);

			b3_clay = view.get3Actions()[0];
			b3_clay.addActionListener(this);

			b3_2wood = view.get3Actions()[1];
			b3_2wood.addActionListener(this);

			b3_resource = view.get3Actions()[2];
			b3_resource.addActionListener(this);

			b3_resource2 = view.get3Actions()[3];
			b3_resource2.addActionListener(this);

			view.get3Texts()[0].setVisible(true);
			view.get3Texts()[1].setVisible(true);

		}

		else if (num_players == 4) {
			wood_4p = 1;
			wood2_4p = 2;
			clay2_4p = 2;
			food_4p = 1;

			view.get4Actions()[0].setVisible(true);
			view.get4Actions()[1].setVisible(true);
			view.get4Actions()[2].setVisible(true);
			view.get4Actions()[3].setVisible(true);
			view.get4Actions()[4].setVisible(true);
			view.get4Actions()[5].setVisible(true);

			b4_wood = view.get4Actions()[0];
			b4_wood.addActionListener(this);

			b4_2clay = view.get4Actions()[1];
			b4_2clay.addActionListener(this);

			b4_2wood = view.get4Actions()[2];
			b4_2wood.addActionListener(this);

			b4_food = view.get4Actions()[3];
			b4_food.addActionListener(this);

			b4_resource = view.get4Actions()[4];
			b4_resource.addActionListener(this);

			b4_3resource = view.get4Actions()[5];
			b4_3resource.addActionListener(this);

			view.get4Texts()[0].setVisible(true);
			view.get4Texts()[1].setVisible(true);
			view.get4Texts()[2].setVisible(true);
			view.get4Texts()[3].setVisible(true);
		} else if (num_players == 5) {
			wood4_5p = 4;
			clay3_5p = 3;
			food_5p = 1;
			reed_5p = 1;

			view.get5Actions()[0].setVisible(true);
			view.get5Actions()[1].setVisible(true);
			view.get5Actions()[2].setVisible(true);
			view.get5Actions()[3].setVisible(true);
			view.get5Actions()[4].setVisible(true);
			view.get5Actions()[5].setVisible(true);

			b5_4wood = view.get5Actions()[0];
			b5_4wood.addActionListener(this);

			b5_3clay = view.get5Actions()[1];
			b5_3clay.addActionListener(this);

			b5_roomfood = view.get5Actions()[2];
			b5_roomfood.addActionListener(this);

			b5_reed = view.get5Actions()[3];
			b5_reed.addActionListener(this);

			b5_animals = view.get5Actions()[4];
			b5_animals.addActionListener(this);

			b5_resource = view.get5Actions()[5];
			b5_resource.addActionListener(this);

			view.get5Texts()[0].setVisible(true);
			view.get5Texts()[1].setVisible(true);
			view.get5Texts()[2].setVisible(true);
			view.get5Texts()[3].setVisible(true);

		}

		// all button initilizations
		b_room = view.getActions()[0];
		b_room.addActionListener(this);

		b_start = view.getActions()[1];
		b_start.addActionListener(this);

		b_grain = view.getActions()[2];
		b_grain.addActionListener(this);

		b_field = view.getActions()[3];
		b_field.addActionListener(this);

		b_stable = view.getActions()[4];
		b_stable.addActionListener(this);

		b_day = view.getActions()[5];
		b_day.addActionListener(this);

		b_wood = view.getActions()[6];
		b_wood.addActionListener(this);

		b_clay = view.getActions()[7];
		b_clay.addActionListener(this);

		b_reed = view.getActions()[8];
		b_reed.addActionListener(this);

		b_food = view.getActions()[9];
		b_food.addActionListener(this);

		b_sheep = view.getActions()[10];
		b_sheep.addActionListener(this);

		b_sow = view.getActions()[11];
		b_sow.setVisible(false);
		b_sow.addActionListener(this);

		b_fences = view.getActions()[12];
		b_fences.setVisible(false);
		b_fences.addActionListener(this);

		b_improve = view.getActions()[13];
		b_improve.setVisible(false);
		b_improve.addActionListener(this);

		b_stone = view.getActions()[14];
		b_stone.setVisible(false);
		b_stone.addActionListener(this);

		b_growth = view.getActions()[15];
		b_growth.setVisible(false);
		b_growth.addActionListener(this);

		b_renov = view.getActions()[16];
		b_renov.setVisible(false);
		b_renov.addActionListener(this);

		b_boar = view.getActions()[17];
		b_boar.setVisible(false);
		b_boar.addActionListener(this);

		b_vege = view.getActions()[18];
		b_vege.setVisible(false);
		b_vege.addActionListener(this);

		b_cattle = view.getActions()[19];
		b_cattle.setVisible(false);
		b_cattle.addActionListener(this);

		b_stone2 = view.getActions()[20];
		b_stone2.setVisible(false);
		b_stone2.addActionListener(this);

		b_growth2 = view.getActions()[21];
		b_growth2.setVisible(false);
		b_growth2.addActionListener(this);

		b_fieldsow = view.getActions()[22];
		b_fieldsow.setVisible(false);
		b_fieldsow.addActionListener(this);

		b_renov2 = view.getActions()[23];
		b_renov2.setVisible(false);
		b_renov2.addActionListener(this);

		b_finish = view.getActions()[24];
		b_finish.addActionListener(this);
		b_finish.setVisible(false);

		view.setVisible(true);
		view.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// farm buttons
		for (int r = 0; r < 7; r++) {
			for (int col = 0; col < 11; col++) {
				if (b[r][col].isEnabled()) {
					b[r][col].addActionListener(this);
					b[r][col].addMouseListener(this);
				}
			}
		}

	}*/

	public void mouseEntered(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {

		// fences were the most complicated of actions because it requires
		// multiple successive clicks and the game knowing if a fence encloses
		// an area or not
		
		if (e.getSource() instanceof JButton) {
			if (wFences || wFences2) {
				if (e.getActionCommand().equals("Finish Action")
						|| players[cur_player].getWood() == 0) {
					if (wFences) {
						players[cur_player].useFam();
						b_fences.setVisible(false);
					}
					wFences = false;
					wFences2 = false;
					update(false);
				} else {
					// button sizes were not exactly the same so I had to map
					// out all the possiblities of a player clicking on an empty
					// fence space in the farm array
					int x = 15;
					int y = 15;
					if (((JButton) e.getSource()).location().y == 4)
						y = 0;
					else if (((JButton) e.getSource()).location().y == 14)
						y = 1;
					else if (((JButton) e.getSource()).location().y == 114)
						y = 2;
					else if (((JButton) e.getSource()).location().y == 124)
						y = 3;
					else if (((JButton) e.getSource()).location().y == 224)
						y = 4;
					else if (((JButton) e.getSource()).location().y == 234)
						y = 5;
					else if (((JButton) e.getSource()).location().y == 334)
						y = 6;

					if (((JButton) e.getSource()).location().x == 3)
						x = 0;
					else if (((JButton) e.getSource()).location().x == 37)
						x = 1;
					else if (((JButton) e.getSource()).location().x == 121)
						x = 2;
					else if (((JButton) e.getSource()).location().x == 155)
						x = 3;
					else if (((JButton) e.getSource()).location().x == 239)
						x = 4;
					else if (((JButton) e.getSource()).location().x == 273)
						x = 5;
					else if (((JButton) e.getSource()).location().x == 357)
						x = 6;
					else if (((JButton) e.getSource()).location().x == 391)
						x = 7;
					else if (((JButton) e.getSource()).location().x == 475)
						x = 8;
					else if (((JButton) e.getSource()).location().x == 509)
						x = 9;
					else if (((JButton) e.getSource()).location().x == 593)
						x = 10;

					if (x != 15 && y != 15) {
						// building 1 fence at a time and then checking if a
						// pasture was made from any angle around it.
						// V=verticle half of pasture, h=horizontal half, the
						// settype function makes the space a pasture if V and h
						// are true
						if (farm[cur_player][y][x].getType() == 'e'
								&& !farm[cur_player][y][x].isSquare()) {
							farm[cur_player][y][x].setType('x');
							players[cur_player].addWood(-1);

							if (x % 2 == 1) {

								if (y == 0) {
									if (farm[cur_player][y + 6][x].getType() == 'x') {
										if (farm[cur_player][y + 5][x]
												.getType() == 'e'
												|| farm[cur_player][y + 5][x]
														.getType() == 'h')
											if (farm[cur_player][y + 5][x]
													.setType('V'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y + 3][x]
												.getType() == 'e'
												|| farm[cur_player][y + 3][x]
														.getType() == 'h')
											if (farm[cur_player][y + 3][x]
													.setType('V'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y + 1][x]
												.getType() == 'e'
												|| farm[cur_player][y + 1][x]
														.getType() == 'h')
											if (farm[cur_player][y + 1][x]
													.setType('V'))
												players[cur_player]
														.addPasture(1);
									}
								}

								if (y == 0 || y == 2)
									if (farm[cur_player][y + 4][x].getType() == 'x') {
										if (farm[cur_player][y + 3][x]
												.getType() == 'e'
												|| farm[cur_player][y + 3][x]
														.getType() == 'h')
											if (farm[cur_player][y + 3][x]
													.setType('V'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y + 1][x]
												.getType() == 'e'
												|| farm[cur_player][y + 1][x]
														.getType() == 'h')
											if (farm[cur_player][y + 1][x]
													.setType('V'))
												players[cur_player]
														.addPasture(1);
									}

								if (y == 0 || y == 2 || y == 4)
									if (farm[cur_player][y + 2][x].getType() == 'x') {
										if (farm[cur_player][y + 1][x]
												.getType() == 'e'
												|| farm[cur_player][y + 1][x]
														.getType() == 'h')
											if (farm[cur_player][y + 1][x]
													.setType('V'))
												players[cur_player]
														.addPasture(1);
									}

								if (y == 2 || y == 4 || y == 6) {
									if (farm[cur_player][y - 2][x].getType() == 'x') {
										if (farm[cur_player][y - 1][x]
												.getType() == 'e'
												|| farm[cur_player][y - 1][x]
														.getType() == 'h')
											if (farm[cur_player][y - 1][x]
													.setType('V'))
												players[cur_player]
														.addPasture(1);
									}

								}
								if (y == 4 || y == 6) {
									if (farm[cur_player][y - 4][x].getType() == 'x') {
										if (farm[cur_player][y - 3][x]
												.getType() == 'e'
												|| farm[cur_player][y - 3][x]
														.getType() == 'h')
											if (farm[cur_player][y - 3][x]
													.setType('V'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y - 1][x]
												.getType() == 'e'
												|| farm[cur_player][y - 1][x]
														.getType() == 'h')
											if (farm[cur_player][y - 1][x]
													.setType('V'))
												players[cur_player]
														.addPasture(1);
									}

								}
								if (y == 6) {
									if (farm[cur_player][y - 6][x].getType() == 'x') {
										if (farm[cur_player][y - 5][x]
												.getType() == 'e'
												|| farm[cur_player][y - 5][x]
														.getType() == 'h')
											if (farm[cur_player][y - 5][x]
													.setType('V'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y - 3][x]
												.getType() == 'e'
												|| farm[cur_player][y - 3][x]
														.getType() == 'h')
											if (farm[cur_player][y - 3][x]
													.setType('V'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y - 1][x]
												.getType() == 'e'
												|| farm[cur_player][y - 1][x]
														.getType() == 'h')
											if (farm[cur_player][y - 1][x]
													.setType('V'))
												players[cur_player]
														.addPasture(1);
									}
								}

							}

							else {
								if (x == 2) {
									if (farm[cur_player][y][x + 8].getType() == 'x') {
										if (farm[cur_player][y][x + 7]
												.getType() == 'e'
												|| farm[cur_player][y][x + 7]
														.getType() == 'V')
											if (farm[cur_player][y][x + 7]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y][x + 5]
												.getType() == 'e'
												|| farm[cur_player][y][x + 5]
														.getType() == 'V')
											if (farm[cur_player][y][x + 5]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y][x + 3]
												.getType() == 'e'
												|| farm[cur_player][y][x + 3]
														.getType() == 'V')
											if (farm[cur_player][y][x + 3]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y][x + 1]
												.getType() == 'e'
												|| farm[cur_player][y][x + 1]
														.getType() == 'V')
											if (farm[cur_player][y][x + 1]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
									}
								}
								if (x == 2 || x == 4) {
									if (farm[cur_player][y][x + 6].getType() == 'x') {
										if (farm[cur_player][y][x + 5]
												.getType() == 'e'
												|| farm[cur_player][y][x + 5]
														.getType() == 'V')
											if (farm[cur_player][y][x + 5]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y][x + 3]
												.getType() == 'e'
												|| farm[cur_player][y][x + 3]
														.getType() == 'V')
											if (farm[cur_player][y][x + 3]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y][x + 1]
												.getType() == 'e'
												|| farm[cur_player][y][x + 1]
														.getType() == 'V')
											if (farm[cur_player][y][x + 1]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
									}

								}
								if (x == 2 || x == 4 || x == 6) {
									if (farm[cur_player][y][x + 4].getType() == 'x') {
										if (farm[cur_player][y][x + 3]
												.getType() == 'e'
												|| farm[cur_player][y][x + 3]
														.getType() == 'V')
											if (farm[cur_player][y][x + 3]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y][x + 1]
												.getType() == 'e'
												|| farm[cur_player][y][x + 1]
														.getType() == 'V')
											if (farm[cur_player][y][x + 1]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
									}
								}
								if (x == 2 || x == 4 || x == 6 || x == 8) {
									if (farm[cur_player][y][x + 2].getType() == 'x') {
										if (farm[cur_player][y][x + 1]
												.getType() == 'e'
												|| farm[cur_player][y][x + 1]
														.getType() == 'V')
											if (farm[cur_player][y][x + 1]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
									}
								}

								if (x == 10) {
									if (farm[cur_player][y][x - 8].getType() == 'x') {
										if (farm[cur_player][y][x - 7]
												.getType() == 'e'
												|| farm[cur_player][y][x - 7]
														.getType() == 'V')
											if (farm[cur_player][y][x - 7]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y][x - 5]
												.getType() == 'e'
												|| farm[cur_player][y][x - 5]
														.getType() == 'V')
											if (farm[cur_player][y][x - 5]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y][x - 3]
												.getType() == 'e'
												|| farm[cur_player][y][x - 3]
														.getType() == 'V')
											if (farm[cur_player][y][x - 3]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y][x - 1]
												.getType() == 'e'
												|| farm[cur_player][y][x - 1]
														.getType() == 'V')
											if (farm[cur_player][y][x - 1]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
									}
								}
								if (x == 10 || x == 8) {
									if (farm[cur_player][y][x - 6].getType() == 'x') {
										if (farm[cur_player][y][x - 5]
												.getType() == 'e'
												|| farm[cur_player][y][x - 5]
														.getType() == 'V')
											if (farm[cur_player][y][x - 5]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y][x - 3]
												.getType() == 'e'
												|| farm[cur_player][y][x - 3]
														.getType() == 'V')
											if (farm[cur_player][y][x - 3]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y][x - 1]
												.getType() == 'e'
												|| farm[cur_player][y][x - 1]
														.getType() == 'V')
											if (farm[cur_player][y][x - 1]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
									}

								}
								if (x == 10 || x == 8 || x == 6) {
									if (farm[cur_player][y][x - 4].getType() == 'x') {
										if (farm[cur_player][y][x - 3]
												.getType() == 'e'
												|| farm[cur_player][y][x - 3]
														.getType() == 'V')
											if (farm[cur_player][y][x - 3]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
										if (farm[cur_player][y][x - 1]
												.getType() == 'e'
												|| farm[cur_player][y][x - 1]
														.getType() == 'V')
											if (farm[cur_player][y][x - 1]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
									}
								}
								if (x == 10 || x == 4 || x == 6 || x == 8) {
									if (farm[cur_player][y][x - 2].getType() == 'x') {
										if (farm[cur_player][y][x - 1]
												.getType() == 'e'
												|| farm[cur_player][y][x - 1]
														.getType() == 'V')
											if (farm[cur_player][y][x - 1]
													.setType('h'))
												players[cur_player]
														.addPasture(1);
									}
								}

							}

							playerupdate();
							updateFarm(false);
						}
					}
				}
			}

			if (e.getActionCommand().equals("GetSpaceTypes")) {
				displaySpaceTypes();
				return;
			}
			
			// first button press selection, since this requires the player to
			// click on a farm place the action is not done here but later on
			// when the w variables read as true
			if (e.getActionCommand()
					.equals("Build rooms [5 wood/clay/stone and 2 reed] and/or build stables [2 wood]")) {

				Object roomorstable[] = { "Build Room", "Build Stable" };

				int selectedValue = JOptionPane.showOptionDialog(null,
						"Take Resource", "Choose one",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, roomorstable, roomorstable[0]);

				if (selectedValue == 0) {

					if (players[cur_player].getReed() < 2)
						JOptionPane.showMessageDialog(null, "Not enough reed",
								"insufficient resources",
								JOptionPane.ERROR_MESSAGE);

					else if (players[cur_player].getRoomType() == 'w') {
						if (players[cur_player].getWood() < 5)
							JOptionPane.showMessageDialog(null,
									"Not enough wood",
									"insufficient resources",
									JOptionPane.ERROR_MESSAGE);
						else
							wRoom = true;

					}

					else if (players[cur_player].getRoomType() == 'c') {
						if (players[cur_player].getClay() < 5)
							JOptionPane.showMessageDialog(null,
									"Not enough clay",
									"insufficient resources",
									JOptionPane.ERROR_MESSAGE);
						else
							wRoom = true;

					}

					else {
						if (players[cur_player].getStone() < 5)
							JOptionPane.showMessageDialog(null,
									"Not enough stone",
									"insufficient resources",
									JOptionPane.ERROR_MESSAGE);
						else
							wRoom = true;

					}

				}

				else {
					if (players[cur_player].getWood() < 2)
						JOptionPane.showMessageDialog(null, "Not enough wood",
								"insufficient resources",
								JOptionPane.ERROR_MESSAGE);
					else
						wStable = true;
				}

			}

			// mostly simple actions
			else if (e.getActionCommand().equals(
					"Starting Player and take 1 Food")) {
				b_start.setVisible(false);
				players[cur_player].addFood(1);
				players[cur_player].useFam();
				start_player = cur_player;

				update(false);

			}

			else if (e.getActionCommand().equals("Take 1 Grain")) {
				b_grain.setVisible(false);
				players[cur_player].addGrain(1);
				players[cur_player].useFam();

				update(false);
			}

			else if (e.getActionCommand().equals("Plow 1 Field")) {
				wField = true;

			}

			// stable moves the action to a w(ait) variable, bake bread
			// automatically bakes 1 grain at a time on the players best oven or
			// fireplace/hearth
			// ovens have limited bread uses, but the action lets them continue
			// baking until all the uses are done or the player runs out of
			// grain
			else if (e.getActionCommand().equals(
					"Build 1 Stable [1 wood] and/or Bake Bread")) {
				int tempSOven = 2;
				int tempCOven = 1;
				Object stabbread[] = { "Build Stable", "Bake Bread", "Done" };
				int selectedValue = 1;

				while (selectedValue == 1) {

					selectedValue = JOptionPane.showOptionDialog(null,
							"Choose Action", "Choose one",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, stabbread,
							stabbread[0]);

					if (selectedValue == 0) {

						if (players[cur_player].getWood() > 0)
							wStableRoom = true;
					} else if (selectedValue == 1) {
						if (players[cur_player].getGrain() > 0) {

							if (players[cur_player].hasCOven() && tempCOven > 0) {
								tempCOven--;
								players[cur_player].addFood(5);
								players[cur_player].addGrain(-1);
							} else if (players[cur_player].hasSOven()
									&& tempSOven > 0) {
								tempSOven--;
								players[cur_player].addFood(4);
								players[cur_player].addGrain(-1);
							} else if (players[cur_player].hasHearth()) {
								players[cur_player].addFood(3);
								players[cur_player].addGrain(-1);
							} else if (players[cur_player].hasFireplace()) {
								players[cur_player].addFood(2);
								players[cur_player].addGrain(-1);
							} else
								JOptionPane
										.showMessageDialog(
												null,
												"You do not have a Hearth/Fireplace or you already used your oven's action!",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
						} else
							JOptionPane.showMessageDialog(null,
									"You do not have grain to bake!",
									"insufficient resources",
									JOptionPane.ERROR_MESSAGE);

					} else {
						b_stable.setVisible(false);
						players[cur_player].useFam();
						update(false);
					}
				}

			}

			else if (e.getActionCommand().equals(
					"Take 1 food and 1 wood, clay, reed, or stone")) {
				b_day.setVisible(false);
				players[cur_player].addFood(food);
				players[cur_player].useFam();

				Object[] possibleValues = { "Wood", "Clay", "Reed" };
				int selectedValue = JOptionPane.showOptionDialog(null,
						"Take Resource", "Choose one",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, possibleValues, possibleValues[0]);

				if (selectedValue == 0) {
					players[cur_player].addWood(1);
				} else if (selectedValue == 1) {
					players[cur_player].addClay(1);
				} else
					players[cur_player].addReed(1);

				update(false);

			} else if (e.getActionCommand().equals(
					"Take wood (+3 per round) (+2 in 1p)")) {
				b_wood.setVisible(false);
				players[cur_player].addWood(wood);
				wood = 0;
				players[cur_player].useFam();

				update(false);
			} else if (e.getActionCommand().equals("Take clay (+1 per round)")) {
				b_clay.setVisible(false);
				players[cur_player].addClay(clay);
				clay = 0;
				players[cur_player].useFam();

				update(false);
			} else if (e.getActionCommand().equals("Take reed (+1 per round)")) {
				b_reed.setVisible(false);
				players[cur_player].addReed(reed);
				reed = 0;
				players[cur_player].useFam();

				update(false);
			} else if (e.getActionCommand().equals("Take food (+1 per round)")) {
				b_food.setVisible(false);
				players[cur_player].addFood(food);
				food = 0;
				players[cur_player].useFam();

				update(false);
			} else if (e.getActionCommand().equals("Take sheep (+1 per round)")) {
				b_sheep.setVisible(false);
				players[cur_player].addSheep(sheep);
				sheep = 0;
				players[cur_player].useFam();

				update(false);
			}

			// Sow does not let the player pick which field is sown, but that is
			// irrelavent to the game because field spaces are permanent so any
			// open field is sown
			// the player picks one at a time whether he is sowing vegetables,
			// grain, or however much he wants of both. Bake bread is similiar
			// to the earlier action
			else if (e.getActionCommand().equals("Sow and/or Bake bread")) {
				int selectedValue = 0;
				int tempCOven = 1;
				int tempSOven = 2;
				boolean tempcontinue;
				Object[] possibleValues = { "Sow Grain", "Sow Vegetable",
						"Bake Bread", "Done Action" };
				while (selectedValue != 3) {

					selectedValue = JOptionPane.showOptionDialog(null,
							"Choose Action", "Choose one",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, possibleValues,
							possibleValues[0]);

					tempcontinue = true;
					if (selectedValue == 0) {
						if (players[cur_player].getGrain() > 0) {

							for (int r = 0; r < 7; r++) {
								for (int col = 0; col < 11; col++) {

									if (farm[cur_player][r][col].getType() == 'f'
											&& farm[cur_player][r][col]
													.getStack() == 0
											&& tempcontinue) {
										farm[cur_player][r][col].setStack(3);
										farm[cur_player][r][col].setType('g');
										players[cur_player].decGrain();
										tempcontinue = false;
										playerupdate();
										updateFarm(false);
									}
								}
							}
							if (tempcontinue) {
								JOptionPane
										.showMessageDialog(
												null,
												"You do not have any space in your field left!",
												"No Space",
												JOptionPane.ERROR_MESSAGE);
							}
						} else
							JOptionPane.showMessageDialog(null,
									"You do not have any grain left!",
									"No Grain", JOptionPane.ERROR_MESSAGE);

					} else if (selectedValue == 1) {
						if (players[cur_player].getVege() > 0) {

							for (int r = 0; r < 7; r++) {
								for (int col = 0; col < 11; col++) {

									if (farm[cur_player][r][col].getType() == 'f'
											&& farm[cur_player][r][col]
													.getStack() == 0
											&& tempcontinue) {
										farm[cur_player][r][col].setStack(2);
										farm[cur_player][r][col].setType('v');
										players[cur_player].decVege();
										tempcontinue = false;
										playerupdate();
										updateFarm(false);
									}
								}
							}
							if (tempcontinue) {
								JOptionPane
										.showMessageDialog(
												null,
												"You do not have any space in your field left!",
												"No Space",
												JOptionPane.ERROR_MESSAGE);
							}
						} else
							JOptionPane.showMessageDialog(null,
									"You do not have any vegetables left!",
									"No Grain", JOptionPane.ERROR_MESSAGE);
					} else if (selectedValue == 2) {
						if (players[cur_player].getGrain() > 0) {

							if (players[cur_player].hasCOven() && tempCOven > 0) {
								tempCOven--;
								players[cur_player].addFood(5);
								players[cur_player].addGrain(-1);
							} else if (players[cur_player].hasSOven()
									&& tempSOven > 0) {
								tempSOven--;
								players[cur_player].addFood(4);
								players[cur_player].addGrain(-1);
							} else if (players[cur_player].hasHearth()) {
								players[cur_player].addFood(3);
								players[cur_player].addGrain(-1);
							} else if (players[cur_player].hasFireplace()) {
								players[cur_player].addFood(2);
								players[cur_player].addGrain(-1);
							} else
								JOptionPane
										.showMessageDialog(
												null,
												"You do not have a Hearth/Fireplace or you already used your oven's action!",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
						}
						JOptionPane.showMessageDialog(null,
								"You do not have grain to sow!",
								"insufficient resources",
								JOptionPane.ERROR_MESSAGE);

					}

					else {

					}
				}
				players[cur_player].useFam();
				b_sow.setVisible(false);
				update(false);

			}

			// finish button only for the fence space since other build ones
			// always ask for a prompt and fences are too many clicks to be
			// prompted every time
			else if (e.getActionCommand().equals(
					"Build Fences [1 wood per fence]")) {
				if (players[cur_player].getWood() > 0) {

					wFences = true;
					b_finish.setVisible(true);
				}

			}

			// opens the player up for possible major improvements, the
			// interface is difficult to follow but all of the rules and
			// improvements are in this game properly
			else if (e.getActionCommand().equals("Buy 1 Major Improvement")) {
				Object[] possibleValues = { "Fireplace", "Cooking Hearth",
						"Clay Oven", "Stone Oven", "Joinery", "Pottery",
						"Basketmaker", "Well", "Cancel" };
				int selectedValue = 0;

				while (selectedValue != 8) {
					selectedValue = JOptionPane
							.showOptionDialog(
									null,
									"Possible Improvements:\nFireplace: Costs 2 clay (3 clay if first fireplace is taken), worth 1 point for end game and the ability to convert cattle to 3 food and every other food resource to 2 food (grain requires bake bread action)\nCooking Hearth: Costs 4/5 clay or a fireplace, gives 1 point and converts sheeps to 2 food, vegetables, boar, and grain to 3 food, and cattle to 4 food.  Grain must use bake bread action\nClay Oven: costs 3 clay and 1 stone, gives 2 points and converts exactly 1 grain into 5 food when baking bread.  Can bake immediately after purchasing\nStone Oven: Costs 3 stone and 1clay, converts up to 2 grain for 4 food each when baking bread.  Can bake immediately after purchasing\nJoinery: Costs 2 wood and 2 stone, gives 2 points + 1/2/3 points for 3/5/7 wood at games end.  Each harvest, can convert exactly 1 wood into 2 food\nPottery: Costs 2 clay and 2 stone, gives 2 points + 1/2/3 points for 3/5/7 wood at games end.  Each harvest, can convert exactly 1 clay into 2 food\nBasketmaker's Workshop: Costs 2 reed and 2 stone, gives 2 points + 1/2/3 points for 2/4/5 wood at games end.Each harvest, can convert exactly 1 reed into 3 food\nWell: Costs 1 wood, 3 stone, gives 4 points and 1 food at the start of the next 5 rounds\n",
									"Choose one", JOptionPane.DEFAULT_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									possibleValues, possibleValues[0]);

					if (selectedValue == 0) {
						if (fireplace_num == 2) {
							if (players[cur_player].getClay() > 1) {
								players[cur_player].addScore(1);
								if (players[cur_player].hasFireplace())
									players[cur_player].setFireplace2();
								else
									players[cur_player].setFireplace();
								players[cur_player].addClay(-2);
								fireplace_num--;
								b_improve.setVisible(false);
								players[cur_player].useFam();
								view.getGameImprovements()[0].setVisible(false);
								update(false);
								break;

							} else
								JOptionPane.showMessageDialog(null,
										"Not enough clay!",
										"insufficient resources",
										JOptionPane.ERROR_MESSAGE);
						} else if (fireplace_num == 1) {
							if (players[cur_player].getClay() > 2) {
								players[cur_player].addScore(1);
								if (players[cur_player].hasFireplace())
									players[cur_player].setFireplace2();
								else
									players[cur_player].setFireplace();
								players[cur_player].addClay(-3);
								fireplace_num--;
								b_improve.setVisible(false);
								players[cur_player].useFam();
								view.getGameImprovements()[1].setVisible(false);
								update(false);
								break;
							} else
								JOptionPane.showMessageDialog(null,
										"Not enough clay!",
										"insufficient resources",
										JOptionPane.ERROR_MESSAGE);
						} else
							JOptionPane.showMessageDialog(null,
									"That improvement is not available!",
									"Improvement taken!",
									JOptionPane.ERROR_MESSAGE);
					} else if (selectedValue == 1) {
						if (hearth_num > 0) {

							Object[] payingopt = { "Buy with Clay",
									"Buy with Fireplace" };

							int payingVal = JOptionPane.showOptionDialog(null,
									"Choose Method of Payment", "Choose one",
									JOptionPane.DEFAULT_OPTION,
									JOptionPane.PLAIN_MESSAGE, null, payingopt,
									payingopt[0]);

							if (payingVal == 0) {
								if (hearth_num == 2) {
									if (players[cur_player].getClay() > 3) {
										players[cur_player].addScore(1);
										if (!players[cur_player].hasHearth())
											players[cur_player].setHearth();
										players[cur_player].addClay(-4);
										hearth_num--;
										b_improve.setVisible(false);
										players[cur_player].useFam();
										view.getGameImprovements()[2]
												.setVisible(false);
										update(false);
										break;
									} else
										JOptionPane.showMessageDialog(null,
												"Not enough clay!",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
								}

								else if (hearth_num == 1) {
									if (players[cur_player].getClay() > 4) {
										players[cur_player].addScore(1);
										if (!players[cur_player].hasHearth())
											players[cur_player].setHearth();
										players[cur_player].addClay(-5);
										hearth_num--;
										b_improve.setVisible(false);
										players[cur_player].useFam();
										view.getGameImprovements()[3]
												.setVisible(false);
										update(false);
										break;
									} else
										JOptionPane.showMessageDialog(null,
												"Not enough clay!",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
								}

							} else {
								if (players[cur_player].hasFireplace()) {
									if (players[cur_player].hasFireplace2()) {

										players[cur_player].setFireplace2();
										view.getGameImprovements()[1]
												.setVisible(true);
									} else {
										players[cur_player].setFireplace();
										view.getGameImprovements()[0]
												.setVisible(true);
									}

									if (!players[cur_player].hasHearth())
										players[cur_player].setHearth();
									if (hearth_num == 2)
										view.getGameImprovements()[2]
												.setVisible(false);

									else
										view.getGameImprovements()[3]
												.setVisible(false);
									hearth_num--;
									b_improve.setVisible(false);
									players[cur_player].useFam();
									update(false);
									break;

								} else
									JOptionPane
											.showMessageDialog(
													null,
													"You must have a fireplace to return!",
													"insufficient resources",
													JOptionPane.ERROR_MESSAGE);
							}
						} else
							JOptionPane.showMessageDialog(null,
									"That improvement is not available!",
									"Improvement taken!",
									JOptionPane.ERROR_MESSAGE);
					} else if (selectedValue == 2) {
						if (clay_oven) {
							if (players[cur_player].getClay() > 2
									&& players[cur_player].getStone() > 0) {
								players[cur_player].addScore(2);
								players[cur_player].setCOven();
								players[cur_player].addClay(-3);
								players[cur_player].addStone(-1);
								b_improve.setVisible(false);
								players[cur_player].useFam();
								clay_oven = false;
								view.getGameImprovements()[4].setVisible(false);
								update(false);
								break;

							} else
								JOptionPane.showMessageDialog(null,
										"Not enough resources!",
										"insufficient resources",
										JOptionPane.ERROR_MESSAGE);
						} else
							JOptionPane.showMessageDialog(null,
									"That improvement is not available!",
									"Improvement taken!",
									JOptionPane.ERROR_MESSAGE);

					} else if (selectedValue == 3) {
						if (stone_oven) {
							if (players[cur_player].getClay() > 0
									&& players[cur_player].getStone() > 2) {
								players[cur_player].addScore(3);
								players[cur_player].setSOven();
								players[cur_player].addClay(-1);
								players[cur_player].addStone(-3);
								b_improve.setVisible(false);
								players[cur_player].useFam();
								view.getGameImprovements()[5].setVisible(false);
								stone_oven = false;
								update(false);
								break;

							} else
								JOptionPane.showMessageDialog(null,
										"Not enough resources!",
										"insufficient resources",
										JOptionPane.ERROR_MESSAGE);
						} else
							JOptionPane.showMessageDialog(null,
									"That improvement is not available!",
									"Improvement taken!",
									JOptionPane.ERROR_MESSAGE);

					}

					else if (selectedValue == 4) {
						if (wood_converter) {
							if (players[cur_player].getWood() > 1
									&& players[cur_player].getStone() > 1) {
								players[cur_player].addScore(2);
								players[cur_player].setJoinery();
								players[cur_player].addWood(-2);
								players[cur_player].addStone(-2);
								b_improve.setVisible(false);
								players[cur_player].useFam();
								view.getGameImprovements()[6].setVisible(false);
								wood_converter = false;
								update(false);
								break;

							} else
								JOptionPane.showMessageDialog(null,
										"Not enough resources!",
										"insufficient resources",
										JOptionPane.ERROR_MESSAGE);
						} else
							JOptionPane.showMessageDialog(null,
									"That improvement is not available!",
									"Improvement taken!",
									JOptionPane.ERROR_MESSAGE);

					}

					else if (selectedValue == 5) {
						if (clay_converter) {
							if (players[cur_player].getClay() > 1
									&& players[cur_player].getStone() > 1) {
								players[cur_player].addScore(2);
								players[cur_player].setPottery();
								players[cur_player].addClay(-2);
								players[cur_player].addStone(-2);
								b_improve.setVisible(false);
								players[cur_player].useFam();
								view.getGameImprovements()[7].setVisible(false);
								clay_converter = false;
								update(false);
								break;

							} else
								JOptionPane.showMessageDialog(null,
										"Not enough resources!",
										"insufficient resources",
										JOptionPane.ERROR_MESSAGE);
						} else
							JOptionPane.showMessageDialog(null,
									"That improvement is not available!",
									"Improvement taken!",
									JOptionPane.ERROR_MESSAGE);

					}

					else if (selectedValue == 6) {
						if (reed_converter) {
							if (players[cur_player].getReed() > 1
									&& players[cur_player].getStone() > 1) {
								players[cur_player].addScore(2);
								players[cur_player].setBasket();
								players[cur_player].addReed(-2);
								players[cur_player].addStone(-2);
								b_improve.setVisible(false);
								players[cur_player].useFam();
								reed_converter = false;
								view.getGameImprovements()[8].setVisible(false);
								update(false);
								break;

							} else
								JOptionPane.showMessageDialog(null,
										"Not enough resources!",
										"insufficient resources",
										JOptionPane.ERROR_MESSAGE);
						} else
							JOptionPane.showMessageDialog(null,
									"That improvement is not available!",
									"Improvement taken!",
									JOptionPane.ERROR_MESSAGE);

					}

					else if (selectedValue == 7) {
						if (well) {
							if (players[cur_player].getWood() > 0
									&& players[cur_player].getStone() > 2) {
								players[cur_player].addScore(2);
								players[cur_player].setWell();
								players[cur_player].addWood(-1);
								players[cur_player].addStone(-3);
								b_improve.setVisible(false);
								players[cur_player].useFam();
								well = false;
								view.getGameImprovements()[9].setVisible(false);
								update(false);
								break;
							} else
								JOptionPane.showMessageDialog(null,
										"Not enough resources!",
										"insufficient resources",
										JOptionPane.ERROR_MESSAGE);
						} else
							JOptionPane.showMessageDialog(null,
									"That improvement is not available!",
									"Improvement taken!",
									JOptionPane.ERROR_MESSAGE);

					} else {
						// do nothing since cancel was hit
					}

				}

			} else if (e.getActionCommand().equals(
					"Take 1 stone (+1 per round)")) {
				b_stone.setVisible(false);
				players[cur_player].addStone(stone);
				stone = 0;
				players[cur_player].useFam();

				update(false);
			}

			// adds a family member, considering a newborn so they can't
			// immediately take action and takes less food to feed if a harvest
			// is happening at round's end
			else if (e.getActionCommand().equals("Family Growth (after round)")) {
				if (players[cur_player].getRooms() == players[cur_player]
						.getFamily())
					JOptionPane
							.showMessageDialog(
									null,
									"You must have an unoccupied room to grow your family",
									"No room", JOptionPane.ERROR_MESSAGE);
				else {

					players[cur_player].addFamily();
					players[cur_player].useFam();
					b_growth.setVisible(false);
					update(false);
				}

			}

			// players cannot skip clay renovations so their house is
			// automatically upgraded, then improvements menu is opened
			else if (e
					.getActionCommand()
					.equals("Renovate [1 reed plus 1 clay/stone per room] also 1 Major Improvement")) {
				boolean cont = false;
				if (players[cur_player].getReed() > 0) {

					if (farm[cur_player][3][1].getType() == 'w') {
						if (players[cur_player].getClay() < players[cur_player]
								.getRooms()) {
							JOptionPane.showMessageDialog(null,
									"Not enough Clay",
									"insufficient resources",
									JOptionPane.ERROR_MESSAGE);
						} else {
							cont = true;
							players[cur_player].setRoomType('c');
							players[cur_player].addClay(-(players[cur_player]
									.getRooms()));
							players[cur_player].addReed(-1);
							for (int r = 0; r < 7; r++) {
								for (int col = 0; col < 11; col++) {

									if (farm[cur_player][r][col].getType() == 'w')
										farm[cur_player][r][col].setType('c');
								}
							}
						}
					} else if (farm[cur_player][3][1].getType() == 'c') {
						if (players[cur_player].getStone() < players[cur_player]
								.getRooms()) {
							JOptionPane.showMessageDialog(null,
									"Not enough Stone",
									"insufficient resources",
									JOptionPane.ERROR_MESSAGE);
						} else {
							players[cur_player].setRoomType('s');
							cont = true;

							players[cur_player].addStone(-(players[cur_player]
									.getRooms()));
							players[cur_player].addReed(-1);
							for (int r = 0; r < 7; r++) {
								for (int col = 0; col < 11; col++) {

									if (farm[cur_player][r][col].getType() == 'c')
										farm[cur_player][r][col].setType('t');
								}

							}
						}
					}
					if (cont) {

						Object[] possibleValues = { "Fireplace",
								"Cooking Hearth", "Clay Oven", "Stone Oven",
								"Joinery", "Pottery", "Basketmaker", "Well",
								"Done" };
						int selectedValue = 0;

						while (selectedValue != 8) {
							selectedValue = JOptionPane
									.showOptionDialog(
											null,
											"Possible Improvements:\nFireplace: Costs 2 clay (3 clay if first fireplace is taken), worth 1 point for end game and the ability to convert cattle to 3 food and every other food resource to 2 food (grain requires bake bread action)\nCooking Hearth: Costs 4/5 clay or a fireplace, gives 1 point and converts sheeps to 2 food, vegetables, boar, and grain to 3 food, and cattle to 4 food.  Grain must use bake bread action\nClay Oven: costs 3 clay and 1 stone, gives 2 points and converts exactly 1 grain into 5 food when baking bread.  Can bake immediately after purchasing\nStone Oven: Costs 3 stone and 1clay, converts up to 2 grain for 4 food each when baking bread.  Can bake immediately after purchasing\nJoinery: Costs 2 wood and 2 stone, gives 2 points + 1/2/3 points for 3/5/7 wood at games end.  Each harvest, can convert exactly 1 wood into 2 food\nPottery: Costs 2 clay and 2 stone, gives 2 points + 1/2/3 points for 3/5/7 wood at games end.  Each harvest, can convert exactly 1 clay into 2 food\nBasketmaker's Workshop: Costs 2 reed and 2 stone, gives 2 points + 1/2/3 points for 2/4/5 wood at games end.Each harvest, can convert exactly 1 reed into 3 food\nWell: Costs 1 wood, 3 stone, gives 4 points and 1 food at the start of the next 5 rounds\n",
											"Choose one",
											JOptionPane.DEFAULT_OPTION,
											JOptionPane.PLAIN_MESSAGE, null,
											possibleValues, possibleValues[0]);

							if (selectedValue == 0) {
								if (fireplace_num == 2) {
									if (players[cur_player].getClay() > 1) {
										players[cur_player].addScore(1);
										if (players[cur_player].hasFireplace())
											players[cur_player].setFireplace2();
										else
											players[cur_player].setFireplace();
										players[cur_player].addClay(-2);
										fireplace_num--;
										b_renov.setVisible(false);
										players[cur_player].useFam();
										view.getGameImprovements()[0]
												.setVisible(false);
										update(false);
										break;

									} else
										JOptionPane.showMessageDialog(null,
												"Not enough clay!",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
								} else if (fireplace_num == 1) {
									if (players[cur_player].getClay() > 2) {
										players[cur_player].addScore(1);
										if (players[cur_player].hasFireplace())
											players[cur_player].setFireplace2();
										else
											players[cur_player].setFireplace();
										players[cur_player].addClay(-3);
										fireplace_num--;
										view.getGameImprovements()[1]
												.setVisible(false);
										b_renov.setVisible(false);
										players[cur_player].useFam();
										update(false);
										break;
									} else
										JOptionPane.showMessageDialog(null,
												"Not enough clay!",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
								} else
									JOptionPane
											.showMessageDialog(
													null,
													"That improvement is not available!",
													"Improvement taken!",
													JOptionPane.ERROR_MESSAGE);
							} else if (selectedValue == 1) {
								if (hearth_num > 0) {

									Object[] payingopt = { "Buy with Clay",
											"Buy with Fireplace" };

									int payingVal = JOptionPane
											.showOptionDialog(null,
													"Choose Method of Payment",
													"Choose one",
													JOptionPane.DEFAULT_OPTION,
													JOptionPane.PLAIN_MESSAGE,
													null, payingopt,
													payingopt[0]);

									if (payingVal == 0) {
										if (hearth_num == 2) {
											if (players[cur_player].getClay() > 3) {
												players[cur_player].addScore(1);
												players[cur_player].setHearth();

												players[cur_player].addClay(-4);
												hearth_num--;
												b_renov.setVisible(false);
												players[cur_player].useFam();
												update(false);

												break;
											} else
												JOptionPane
														.showMessageDialog(
																null,
																"Not enough clay!",
																"insufficient resources",
																JOptionPane.ERROR_MESSAGE);
										} else if (hearth_num == 1) {
											if (players[cur_player].getClay() > 4) {
												players[cur_player].addScore(1);
												if (!players[cur_player]
														.hasHearth())
													players[cur_player]
															.setHearth();
												view.getGameImprovements()[3]
														.setVisible(false);
												players[cur_player].addClay(-5);
												hearth_num--;
												b_renov.setVisible(false);
												players[cur_player].useFam();
												update(false);
												break;
											} else
												JOptionPane
														.showMessageDialog(
																null,
																"Not enough clay!",
																"insufficient resources",
																JOptionPane.ERROR_MESSAGE);
										}

									} else {
										if (players[cur_player].hasFireplace()) {
											if (players[cur_player]
													.hasFireplace2()) {
												view.getGameImprovements()[1]
														.setVisible(true);
												players[cur_player]
														.setFireplace2();
											} else {
												view.getGameImprovements()[0]
														.setVisible(false);
												players[cur_player]
														.setFireplace();
											}

											if (!players[cur_player]
													.hasHearth()) {
												view.getGameImprovements()[2]
														.setVisible(false);
												players[cur_player].setHearth();
											} else
												view.getGameImprovements()[3]
														.setVisible(false);
											hearth_num--;
											b_renov.setVisible(false);
											players[cur_player].useFam();
											update(false);
											break;

										} else
											JOptionPane
													.showMessageDialog(
															null,
															"You must have a fireplace to return!",
															"insufficient resources",
															JOptionPane.ERROR_MESSAGE);
									}
								} else
									JOptionPane
											.showMessageDialog(
													null,
													"That improvement is not available!",
													"Improvement taken!",
													JOptionPane.ERROR_MESSAGE);
							} else if (selectedValue == 2) {
								if (clay_oven) {
									if (players[cur_player].getClay() > 2
											&& players[cur_player].getStone() > 0) {
										players[cur_player].addScore(2);
										players[cur_player].setCOven();
										players[cur_player].addClay(-3);
										players[cur_player].addStone(-1);
										b_renov.setVisible(false);
										players[cur_player].useFam();
										clay_oven = false;
										view.getGameImprovements()[4]
												.setVisible(false);
										update(false);
										break;

									} else
										JOptionPane.showMessageDialog(null,
												"Not enough resources!",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
								} else
									JOptionPane
											.showMessageDialog(
													null,
													"That improvement is not available!",
													"Improvement taken!",
													JOptionPane.ERROR_MESSAGE);

							} else if (selectedValue == 3) {
								if (stone_oven) {
									if (players[cur_player].getClay() > 0
											&& players[cur_player].getStone() > 2) {
										players[cur_player].addScore(3);
										players[cur_player].setSOven();
										players[cur_player].addClay(-1);
										players[cur_player].addStone(-3);
										b_renov.setVisible(false);
										players[cur_player].useFam();
										view.getGameImprovements()[5]
												.setVisible(false);
										stone_oven = false;
										update(false);
										break;

									} else
										JOptionPane.showMessageDialog(null,
												"Not enough resources!",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
								} else
									JOptionPane
											.showMessageDialog(
													null,
													"That improvement is not available!",
													"Improvement taken!",
													JOptionPane.ERROR_MESSAGE);

							}

							else if (selectedValue == 4) {
								if (wood_converter) {
									if (players[cur_player].getWood() > 1
											&& players[cur_player].getStone() > 1) {
										players[cur_player].addScore(2);
										players[cur_player].setJoinery();
										players[cur_player].addWood(-2);
										players[cur_player].addStone(-2);
										b_renov.setVisible(false);
										players[cur_player].useFam();
										view.getGameImprovements()[6]
												.setVisible(false);
										wood_converter = false;
										update(false);
										break;

									} else
										JOptionPane.showMessageDialog(null,
												"Not enough resources!",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
								} else
									JOptionPane
											.showMessageDialog(
													null,
													"That improvement is not available!",
													"Improvement taken!",
													JOptionPane.ERROR_MESSAGE);

							}

							else if (selectedValue == 5) {
								if (clay_converter) {
									if (players[cur_player].getClay() > 1
											&& players[cur_player].getStone() > 1) {
										players[cur_player].addScore(2);
										players[cur_player].setPottery();
										players[cur_player].addClay(-2);
										players[cur_player].addStone(-2);
										b_renov.setVisible(false);
										players[cur_player].useFam();
										view.getGameImprovements()[7]
												.setVisible(false);
										clay_converter = false;
										update(false);
										break;

									} else
										JOptionPane.showMessageDialog(null,
												"Not enough resources!",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
								} else
									JOptionPane
											.showMessageDialog(
													null,
													"That improvement is not available!",
													"Improvement taken!",
													JOptionPane.ERROR_MESSAGE);

							}

							else if (selectedValue == 6) {
								if (reed_converter) {
									if (players[cur_player].getReed() > 1
											&& players[cur_player].getStone() > 1) {
										players[cur_player].addScore(2);
										players[cur_player].setBasket();
										players[cur_player].addReed(-2);
										players[cur_player].addStone(-2);
										b_renov.setVisible(false);
										players[cur_player].useFam();
										reed_converter = false;
										view.getGameImprovements()[8]
												.setVisible(false);
										update(false);
										break;

									} else
										JOptionPane.showMessageDialog(null,
												"Not enough resources!",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
								} else
									JOptionPane
											.showMessageDialog(
													null,
													"That improvement is not available!",
													"Improvement taken!",
													JOptionPane.ERROR_MESSAGE);

							}

							else if (selectedValue == 7) {
								if (well) {
									if (players[cur_player].getWood() > 0
											&& players[cur_player].getStone() > 2) {
										players[cur_player].addScore(2);
										players[cur_player].setWell();
										players[cur_player].addWood(-1);
										players[cur_player].addStone(-3);
										b_renov.setVisible(false);
										players[cur_player].useFam();
										view.getGameImprovements()[9]
												.setVisible(false);
										well = false;
										update(false);
										break;
									} else
										JOptionPane.showMessageDialog(null,
												"Not enough resources!",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
								} else
									JOptionPane
											.showMessageDialog(
													null,
													"That improvement is not available!",
													"Improvement taken!",
													JOptionPane.ERROR_MESSAGE);

							} else {
								b_renov.setVisible(false);
								update(false);
							}

						}

					}
				} else
					JOptionPane
							.showMessageDialog(null, "Not enough reed",
									"insufficient resources",
									JOptionPane.ERROR_MESSAGE);
			} else if (e.getActionCommand().equals(
					"Take wild boar (+1 per turn)")) {
				b_boar.setVisible(false);
				players[cur_player].addBoar(boar);
				boar = 0;
				players[cur_player].useFam();

				update(false);
			} else if (e.getActionCommand().equals("Take 1 vegetable")) {
				b_vege.setVisible(false);
				players[cur_player].addVege();
				players[cur_player].useFam();

				update(false);
			} else if (e.getActionCommand().equals("Take cattle (+1 per turn)")) {
				b_cattle.setVisible(false);
				players[cur_player].addCattle(cattle);
				cattle = 0;
				players[cur_player].useFam();

				update(false);

			} else if (e.getActionCommand().equals("Take stone(+1 per turn)")) {
				b_stone2.setVisible(false);
				players[cur_player].addStone(stone);
				stone2 = 0;
				players[cur_player].useFam();

				update(false);
			} else if (e.getActionCommand().equals(
					"Family Growth (even without space in your home)")) {
				b_growth2.setVisible(false);
				players[cur_player].addFamily();
				players[cur_player].useFam();

				update(false);

			}

			// asked the user to select plow first for simplicity, and the user
			// would likely want to sow the newly plowed field
			else if (e.getActionCommand().equals("Plow 1 Field and/or Sow")) {
				Object plowchoice[] = { "Plow(Select First)", "Sow Grain",
						"Sow Vegetable", "Done Action" };
				boolean tempcontinue;
				int selectedValue = 0;
				while (selectedValue != 3) {

					selectedValue = JOptionPane.showOptionDialog(null,
							"Choose Action", "Choose one",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, plowchoice,
							plowchoice[0]);

					if (selectedValue == 0) {
						wField2 = true;
						break;
					}

					else if (selectedValue == 1) {
						tempcontinue = true;
						if (players[cur_player].getGrain() > 0) {

							for (int r = 0; r < 7; r++) {
								for (int col = 0; col < 11; col++) {

									if (farm[cur_player][r][col].getType() == 'f'
											&& farm[cur_player][r][col]
													.getStack() == 0
											&& tempcontinue) {
										farm[cur_player][r][col].setStack(3);
										farm[cur_player][r][col].setType('g');
										players[cur_player].decGrain();
										tempcontinue = false;
										playerupdate();
										updateFarm(false);
									}
								}
							}
							if (tempcontinue) {
								JOptionPane
										.showMessageDialog(
												null,
												"You do not have any space in your field left!",
												"No Space",
												JOptionPane.ERROR_MESSAGE);
							}
						} else
							JOptionPane.showMessageDialog(null,
									"You do not have any grain left!",
									"No Grain", JOptionPane.ERROR_MESSAGE);

					} else if (selectedValue == 2) {
						tempcontinue = true;
						if (players[cur_player].getVege() > 0) {

							for (int r = 0; r < 7; r++) {
								for (int col = 0; col < 11; col++) {

									if (farm[cur_player][r][col].getType() == 'f'
											&& farm[cur_player][r][col]
													.getStack() == 0
											&& tempcontinue) {
										farm[cur_player][r][col].setStack(2);
										farm[cur_player][r][col].setType('v');
										players[cur_player].decVege();
										tempcontinue = false;
										playerupdate();
										updateFarm(false);
									}
								}
							}
							if (tempcontinue) {
								JOptionPane
										.showMessageDialog(
												null,
												"You do not have any space in your field left!",
												"No Space",
												JOptionPane.ERROR_MESSAGE);
							}
						} else
							JOptionPane.showMessageDialog(null,
									"You do not have any vegetables left!",
									"No Vegetables", JOptionPane.ERROR_MESSAGE);
					}

				}

			}

			// mix of 2 previous actions basically
			else if (e
					.getActionCommand()
					.equals("Renovate (1 reed plus 1 clay/stone per room) also Fences [1 wood]")) {
				if (players[cur_player].getReed() > 0) {

					if (farm[cur_player][3][1].getType() == 'w') {
						if (players[cur_player].getClay() < players[cur_player]
								.getRooms()) {
							JOptionPane.showMessageDialog(null,
									"Not enough Clay",
									"insufficient resources",
									JOptionPane.ERROR_MESSAGE);
						} else {
							players[cur_player].useFam();
							b_renov.setVisible(false);
							players[cur_player].setRoomType('c');
							players[cur_player].addClay(-(players[cur_player]
									.getRooms()));
							players[cur_player].addReed(-1);
							for (int r = 0; r < 7; r++) {
								for (int col = 0; col < 11; col++) {

									if (farm[cur_player][r][col].getType() == 'w')
										farm[cur_player][r][col].setType('c');
								}
							}
						}
					} else if (farm[cur_player][3][1].getType() == 'c') {
						if (players[cur_player].getStone() < players[cur_player]
								.getRooms()) {
							JOptionPane.showMessageDialog(null,
									"Not enough Stone",
									"insufficient resources",
									JOptionPane.ERROR_MESSAGE);
						} else {
							players[cur_player].useFam();
							b_renov.setVisible(false);
							players[cur_player].setRoomType('s');
							players[cur_player].addStone(-(players[cur_player]
									.getRooms()));
							players[cur_player].addReed(-1);
							for (int r = 0; r < 7; r++) {
								for (int col = 0; col < 11; col++) {

									if (farm[cur_player][r][col].getType() == 'c')
										farm[cur_player][r][col].setType('t');
								}

							}
						}
					}

					Object[] possibleValues = { "Yes", "No" };
					int selectedValue = 0;

					selectedValue = JOptionPane.showOptionDialog(null,
							"Build Fences?", "Fences",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, possibleValues,
							possibleValues[0]);
					if (selectedValue == 0) {
						wFences2 = true;
						b_renov2.setVisible(false);
						b_finish.setVisible(true);
					} else {
						update(false);
					}
				} else
					JOptionPane
							.showMessageDialog(null, "Not enough reed",
									"insufficient resources",
									JOptionPane.ERROR_MESSAGE);

			}

			// ***********************
			// 3 PLAYER ONLY ACTIONS
			// ***********************

			else if (e.getActionCommand().equals("(3p) Clay (+1 per round)")) {
				// clay_3p.setVisible(false);
				b3_clay.setVisible(false);
				players[cur_player].addClay(clay_3p);
				clay_3p = 0;
				players[cur_player].useFam();

				update(false);

			} else if (e.getActionCommand().equals("(3p) Wood (+2 per round)")) {
				b3_2wood.setVisible(false);
				// wood2_3p.setVisible(false);
				players[cur_player].addWood(wood2_3p);
				wood2_3p = 0;
				players[cur_player].useFam();

				update(false);

			}

			else if (e.getActionCommand().equals("(3p) 1 Building Resource")) {
				b3_resource.setVisible(false);
				players[cur_player].useFam();

				Object[] possibleValues4 = { "Wood", "Clay", "Reed", "Stone" };
				int selectedValue = JOptionPane.showOptionDialog(null,
						"Take Resource", "Choose one",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, possibleValues4, possibleValues4[0]);

				if (selectedValue == 0) {
					players[cur_player].addWood(1);
				} else if (selectedValue == 2) {
					players[cur_player].addClay(1);
				} else if (selectedValue == 3)
					players[cur_player].addReed(1);
				else
					players[cur_player].addStone(1);

				update(false);

			}

			else if (e.getActionCommand().equals(
					"(3p) 2 Different Building Resources")) {
				b3_resource2.setVisible(false);
				players[cur_player].useFam();

				Object[] possibleValues4 = { "Wood", "Clay", "Reed", "Stone" };
				Object[] possibleValuesStone = { "Wood", "Clay", "Reed" };
				Object[] possibleValuesClay = { "Wood", "Reed", "Stone" };
				Object[] possibleValuesReed = { "Wood", "Clay", "Stone" };
				Object[] possibleValuesWood = { "Clay", "Reed", "Stone" };
				int selectedValue = JOptionPane.showOptionDialog(null,
						"Take Resource", "Choose one",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, possibleValues4, possibleValues4[0]);

				if (selectedValue == 0) {
					players[cur_player].addWood(1);

					selectedValue = JOptionPane.showOptionDialog(null,
							"Take Resource", "Choose one",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							possibleValuesWood, possibleValuesWood[0]);
					if (selectedValue == 0) {
						players[cur_player].addClay(1);
					} else if (selectedValue == 1)
						players[cur_player].addReed(1);
					else
						players[cur_player].addStone(1);

				} else if (selectedValue == 1) {
					players[cur_player].addClay(1);

					selectedValue = JOptionPane.showOptionDialog(null,
							"Take Resource", "Choose one",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							possibleValuesClay, possibleValuesClay[0]);
					if (selectedValue == 0) {
						players[cur_player].addWood(1);
					} else if (selectedValue == 1)
						players[cur_player].addReed(1);
					else
						players[cur_player].addStone(1);

				} else if (selectedValue == 2) {

					players[cur_player].addReed(1);

					selectedValue = JOptionPane.showOptionDialog(null,
							"Take Resource", "Choose one",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							possibleValuesReed, possibleValuesReed[0]);
					if (selectedValue == 0) {
						players[cur_player].addWood(1);
					} else if (selectedValue == 1)
						players[cur_player].addClay(1);
					else
						players[cur_player].addStone(1);

				} else {

					players[cur_player].addStone(1);

					selectedValue = JOptionPane.showOptionDialog(null,
							"Take Resource", "Choose one",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							possibleValuesStone, possibleValuesStone[0]);
					if (selectedValue == 0) {
						players[cur_player].addWood(1);
					} else if (selectedValue == 1)
						players[cur_player].addClay(1);
					else
						players[cur_player].addReed(1);

				}

				update(false);

			}

			// ***********************
			// 4 PLAYER ONLY ACTIONS
			// ***********************

			else if (e.getActionCommand().equals("(4p) Wood (+1 per round)")) {
				b4_wood.setVisible(false);
				// wood2_3p.setVisible(false);
				players[cur_player].addWood(wood_4p);
				wood_4p = 0;
				players[cur_player].useFam();

				update(false);

			}

			else if (e.getActionCommand().equals("(4p) Clay (+2 per round)")) {
				b4_2clay.setVisible(false);
				// wood2_3p.setVisible(false);
				players[cur_player].addClay(clay2_4p);
				clay2_4p = 0;
				players[cur_player].useFam();

				update(false);

			}

			else if (e.getActionCommand().equals("(4p) Wood (+2 per round)")) {
				b4_2wood.setVisible(false);
				// wood2_3p.setVisible(false);
				players[cur_player].addWood(wood2_4p);
				wood2_4p = 0;
				players[cur_player].useFam();

				update(false);

			}

			else if (e.getActionCommand().equals("(4p) Food (+1 per round)")) {
				b4_food.setVisible(false);
				// wood2_3p.setVisible(false);
				players[cur_player].addFood(food_4p);
				food_4p = 0;
				players[cur_player].useFam();

				update(false);

			}

			else if (e.getActionCommand().equals("(4p) 1 reed, stone & food")) {
				b4_3resource.setVisible(false);
				// wood2_3p.setVisible(false);
				players[cur_player].addReed(1);
				players[cur_player].addStone(1);
				players[cur_player].addFood(1);
				players[cur_player].useFam();

				update(false);

			}

			else if (e.getActionCommand().equals(
					"(4p) 2 Different Building Resources")) {
				b4_resource.setVisible(false);
				players[cur_player].useFam();

				Object[] possibleValues4 = { "Wood", "Clay", "Reed", "Stone" };
				Object[] possibleValuesStone = { "Wood", "Clay", "Reed" };
				Object[] possibleValuesClay = { "Wood", "Reed", "Stone" };
				Object[] possibleValuesReed = { "Wood", "Clay", "Stone" };
				Object[] possibleValuesWood = { "Clay", "Reed", "Stone" };
				int selectedValue = JOptionPane.showOptionDialog(null,
						"Take Resource", "Choose one",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, possibleValues4, possibleValues4[0]);

				if (selectedValue == 0) {
					players[cur_player].addWood(1);

					selectedValue = JOptionPane.showOptionDialog(null,
							"Take Resource", "Choose one",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							possibleValuesWood, possibleValuesWood[0]);
					if (selectedValue == 0) {
						players[cur_player].addClay(1);
					} else if (selectedValue == 1)
						players[cur_player].addReed(1);
					else
						players[cur_player].addStone(1);

				} else if (selectedValue == 1) {
					players[cur_player].addClay(1);

					selectedValue = JOptionPane.showOptionDialog(null,
							"Take Resource", "Choose one",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							possibleValuesClay, possibleValuesClay[0]);
					if (selectedValue == 0) {
						players[cur_player].addWood(1);
					} else if (selectedValue == 1)
						players[cur_player].addReed(1);
					else
						players[cur_player].addStone(1);

				} else if (selectedValue == 2) {

					players[cur_player].addReed(1);

					selectedValue = JOptionPane.showOptionDialog(null,
							"Take Resource", "Choose one",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							possibleValuesReed, possibleValuesReed[0]);
					if (selectedValue == 0) {
						players[cur_player].addWood(1);
					} else if (selectedValue == 1)
						players[cur_player].addClay(1);
					else
						players[cur_player].addStone(1);

				} else {

					players[cur_player].addStone(1);

					selectedValue = JOptionPane.showOptionDialog(null,
							"Take Resource", "Choose one",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							possibleValuesStone, possibleValuesStone[0]);
					if (selectedValue == 0) {
						players[cur_player].addWood(1);
					} else if (selectedValue == 1)
						players[cur_player].addClay(1);
					else
						players[cur_player].addReed(1);

				}

				update(false);

			}

			// ***********************
			// 5 FAMILY MEMBER ACTIONS
			// ***********************

			else if (e.getActionCommand().equals("(5p) Wood (+4 per round)")) {
				b5_4wood.setVisible(false);
				// wood2_3p.setVisible(false);
				players[cur_player].addWood(wood4_5p);
				wood4_5p = 0;
				players[cur_player].useFam();

				update(false);

			}

			else if (e.getActionCommand().equals("(5p) Clay (+3 per round)")) {
				b5_3clay.setVisible(false);
				// wood2_3p.setVisible(false);
				players[cur_player].addClay(clay3_5p);
				clay3_5p = 0;
				players[cur_player].useFam();

				update(false);

			}

			else if (e.getActionCommand().equals(
					"(5p) Build 1 room or take Food (+1 per round)")) {
				// b5_roomfood.setVisible(false);

				Object[] possibleValuesRoomFood = { "Build 1 Room", "Take Food" };
				int selectedValue = JOptionPane.showOptionDialog(null,
						"Action", "Choose one", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null,
						possibleValuesRoomFood, possibleValuesRoomFood);
				if (selectedValue == 0) {
					if (players[cur_player].getReed() < 2)
						JOptionPane.showMessageDialog(null, "Not enough reed",
								"insufficient resources",
								JOptionPane.ERROR_MESSAGE);

					else if (players[cur_player].getRoomType() == 'w') {
						if (players[cur_player].getWood() < 5)
							JOptionPane.showMessageDialog(null,
									"Not enough wood",
									"insufficient resources",
									JOptionPane.ERROR_MESSAGE);
						else
							wRoom5p = true;
					}

					else if (players[cur_player].getRoomType() == 'c') {
						if (players[cur_player].getClay() < 5)
							JOptionPane.showMessageDialog(null,
									"Not enough clay",
									"insufficient resources",
									JOptionPane.ERROR_MESSAGE);
						else
							wRoom5p = true;
					}

					else {
						if (players[cur_player].getStone() < 5)
							JOptionPane.showMessageDialog(null,
									"Not enough stone",
									"insufficient resources",
									JOptionPane.ERROR_MESSAGE);
						else
							wRoom5p = true;
					}

				}

				else {
					b5_roomfood.setVisible(false);
					players[cur_player].addFood(food_5p);
					food_5p = 0;
					players[cur_player].useFam();

					update(false);
				}

			}

			// only reed stacks on this space as it does in the actual game
			else if (e.getActionCommand().equals(
					"(5p) Take Reed (+1 per round) & 1 stone + 1 wood")) {

				b5_reed.setVisible(false);

				players[cur_player].addReed(reed_5p);
				players[cur_player].addStone(1);
				players[cur_player].addWood(1);
				reed_5p = 0;
				players[cur_player].useFam();

				update(false);

			}

			else if (e.getActionCommand().equals(
					"(5p) Take Animal - sheep gives 1 food, cattle costs 1")) {
				Object[] possibleValuesAnimals = { "Sheep+Food", "Boar",
						"Cattle-Food" };
				int selectedValue = JOptionPane.showOptionDialog(null,
						"Choose Animal", "Choose one",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, possibleValuesAnimals, possibleValuesAnimals);

				if (selectedValue == 0) {
					b5_animals.setVisible(false);

					players[cur_player].useFam();
					players[cur_player].addSheep(1);
					players[cur_player].addFood(1);

					update(false);
				} else if (selectedValue == 1) {
					b5_animals.setVisible(false);

					players[cur_player].useFam();
					players[cur_player].addBoar(1);

					update(false);
				} else {
					if (players[cur_player].getFood() < 1)
						JOptionPane.showMessageDialog(null, "Not enough Food",
								"Need 1 Food", JOptionPane.ERROR_MESSAGE);
					else {
						b5_animals.setVisible(false);

						players[cur_player].useFam();
						players[cur_player].addCattle(1);
						players[cur_player].addFood(-1);

						update(false);
					}
				}

			}

			else if (e.getActionCommand().equals(
					"(5p) 2 Different Building Resources or Family Growth")) {

				Object[] possibleChoice2 = { "Resources", "Growth" };
				int selectedValue2 = JOptionPane.showOptionDialog(null,
						"Choose", "Choose one", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, possibleChoice2,
						possibleChoice2[0]);

				if (selectedValue2 == 0) {
					b5_resource.setVisible(false);
					players[cur_player].useFam();

					update(false);

					Object[] possibleValues4 = { "Wood", "Clay", "Reed",
							"Stone" };
					Object[] possibleValuesStone = { "Wood", "Clay", "Reed" };
					Object[] possibleValuesClay = { "Wood", "Reed", "Stone" };
					Object[] possibleValuesReed = { "Wood", "Clay", "Stone" };
					Object[] possibleValuesWood = { "Clay", "Reed", "Stone" };
					int selectedValue = JOptionPane.showOptionDialog(null,
							"Take Resource", "Choose one",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, possibleValues4,
							possibleValues4[0]);

					if (selectedValue == 0) {
						players[cur_player].addWood(1);

						selectedValue = JOptionPane.showOptionDialog(null,
								"Take Resource", "Choose one",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								possibleValuesWood, possibleValuesWood[0]);
						if (selectedValue == 0) {
							players[cur_player].addClay(1);
						} else if (selectedValue == 1)
							players[cur_player].addReed(1);
						else
							players[cur_player].addStone(1);

					} else if (selectedValue == 1) {
						players[cur_player].addClay(1);

						selectedValue = JOptionPane.showOptionDialog(null,
								"Take Resource", "Choose one",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								possibleValuesClay, possibleValuesClay[0]);
						if (selectedValue == 0) {
							players[cur_player].addWood(1);
						} else if (selectedValue == 1)
							players[cur_player].addReed(1);
						else
							players[cur_player].addStone(1);

					} else if (selectedValue == 2) {

						players[cur_player].addReed(1);

						selectedValue = JOptionPane.showOptionDialog(null,
								"Take Resource", "Choose one",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								possibleValuesReed, possibleValuesReed[0]);
						if (selectedValue == 0) {
							players[cur_player].addWood(1);
						} else if (selectedValue == 1)
							players[cur_player].addClay(1);
						else
							players[cur_player].addStone(1);

					} else {

						players[cur_player].addStone(1);

						selectedValue = JOptionPane.showOptionDialog(null,
								"Take Resource", "Choose one",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								possibleValuesStone, possibleValuesStone[0]);
						if (selectedValue == 0) {
							players[cur_player].addWood(1);
						} else if (selectedValue == 1)
							players[cur_player].addClay(1);
						else
							players[cur_player].addReed(1);

					}
				}

				else {
					if (game < 5)
						JOptionPane
								.showMessageDialog(
										null,
										"Growth can only be taken from round 5 onwards",
										"Too Early", JOptionPane.ERROR_MESSAGE);

					else if (players[cur_player].getRooms() == players[cur_player]
							.getFamily())
						JOptionPane
								.showMessageDialog(
										null,
										"You must have an unoccupied room to grow your family",
										"No room", JOptionPane.ERROR_MESSAGE);
					else {

						players[cur_player].addFamily();
						players[cur_player].useFam();

						update(false);
					}
				}
			}

			// **************************************
			// FOLLOW UP BUTTONS TO CLICK ON THE FARM
			// **************************************

			else {

				// reading a player clicking on a field to plow it
				if (wField) {
					if (((JButton) e.getSource()).location().y / 110 * 2 + 1 < 6
							&& ((JButton) e.getSource()).location().x / 118 * 2 + 1 < 10)
						if (farm[cur_player][((JButton) e.getSource())
								.location().y / 110 * 2 + 1][((JButton) e
								.getSource()).location().x / 118 * 2 + 1]
								.getType() == 'e'
								&& farm[cur_player][((JButton) e.getSource())
										.location().y / 110 * 2 + 1][((JButton) e
										.getSource()).location().x / 118 * 2 + 1]
										.isSquare()) {

							b_field.setVisible(false);
							players[cur_player].useFam();
							players[cur_player].decEmpty(1);

							players[cur_player].addField();

							farm[cur_player][((JButton) e.getSource())
									.location().y / 110 * 2 + 1][((JButton) e
									.getSource()).location().x / 118 * 2 + 1]
									.setType('f');
							update(false);

						} else {
							wField = false;
						}

				}
				// reading a player to click on an empty space to build a room
				// for the 5p room button
				if (wRoom5p) {
					if (((JButton) e.getSource()).location().y / 110 * 2 + 1 < 6
							&& ((JButton) e.getSource()).location().x / 118 * 2 + 1 < 10)
						if (farm[cur_player][((JButton) e.getSource())
								.location().y / 110 * 2 + 1][((JButton) e
								.getSource()).location().x / 118 * 2 + 1]
								.getType() == 'e'
								&& farm[cur_player][((JButton) e.getSource())
										.location().y / 110 * 2 + 1][((JButton) e
										.getSource()).location().x / 118 * 2 + 1]
										.isSquare()) {
							players[cur_player].addRooms(1);
							players[cur_player].decEmpty(1);
							farm[cur_player][((JButton) e.getSource())
									.location().y / 110 * 2 + 1][((JButton) e
									.getSource()).location().x / 118 * 2 + 1]
									.setType(farm[cur_player][3][1].getType());

							players[cur_player].addReed(-2);
							if (farm[cur_player][3][1].getType() == 'w')
								players[cur_player].addWood(-5);
							else if (farm[cur_player][3][1].getType() == 'c')
								players[cur_player].addClay(-5);
							else
								players[cur_player].addStone(-5);
							b5_roomfood.setVisible(false);
							players[cur_player].useFam();
							update(false);

						}

				}
				// reading a player to click on an empty space to build a room
				// and then possibly build stables after
				if (wRoom) {
					if (((JButton) e.getSource()).location().y / 110 * 2 + 1 < 6
							&& ((JButton) e.getSource()).location().x / 118 * 2 + 1 < 10)
						if (farm[cur_player][((JButton) e.getSource())
								.location().y / 110 * 2 + 1][((JButton) e
								.getSource()).location().x / 118 * 2 + 1]
								.getType() == 'e'
								&& farm[cur_player][((JButton) e.getSource())
										.location().y / 110 * 2 + 1][((JButton) e
										.getSource()).location().x / 118 * 2 + 1]
										.isSquare()) {
							players[cur_player].addRooms(1);
							players[cur_player].decEmpty(1);
							farm[cur_player][((JButton) e.getSource())
									.location().y / 110 * 2 + 1][((JButton) e
									.getSource()).location().x / 118 * 2 + 1]
									.setType(farm[cur_player][3][1].getType());

							players[cur_player].addReed(-2);
							if (farm[cur_player][3][1].getType() == 'w')
								players[cur_player].addWood(-5);
							else if (farm[cur_player][3][1].getType() == 'c')
								players[cur_player].addClay(-5);
							else
								players[cur_player].addStone(-5);

							playerupdate();
							updateFarm(false);
							Object roomdone[] = { "Build Room", "Build Stable",
									"Done Action" };

							int selectedValue = JOptionPane.showOptionDialog(
									null, "Choose Action", "Choose one",
									JOptionPane.DEFAULT_OPTION,
									JOptionPane.PLAIN_MESSAGE, null, roomdone,
									roomdone[0]);

							if (selectedValue == 0) {

								if (players[cur_player].getReed() < 2) {
									players[cur_player].useFam();
									update(false);
									JOptionPane.showMessageDialog(null,
											"Not enough reed",
											"insufficient resources",
											JOptionPane.ERROR_MESSAGE);
								}

								else if (players[cur_player].getRoomType() == 'w') {
									if (players[cur_player].getWood() < 5) {

										JOptionPane.showMessageDialog(null,
												"Not enough wood",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
										players[cur_player].useFam();
										update(false);
									}

								}

								else if (players[cur_player].getRoomType() == 'c') {
									if (players[cur_player].getClay() < 5) {

										JOptionPane.showMessageDialog(null,
												"Not enough clay",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
										players[cur_player].useFam();
										update(false);
									}

								}

								else {
									if (players[cur_player].getStone() < 5) {
										players[cur_player].useFam();
										update(false);
										JOptionPane.showMessageDialog(null,
												"Not enough stone",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
									}

								}

							}

							else if (selectedValue == 1) {
								if (players[cur_player].getWood() < 2) {
									players[cur_player].useFam();

									update(false);
									JOptionPane.showMessageDialog(null,
											"Not enough wood",
											"insufficient resources",
											JOptionPane.ERROR_MESSAGE);
								} else {
									wRoom = false;
									wStable = true;
								}
							} else {
								players[cur_player].useFam();
								update(false);
							}

						}

				}
				// other half of the previous if statement since the action lets
				// players build rooms and stables
				if (wStable) {
					if (((JButton) e.getSource()).location().y / 110 * 2 + 1 < 6
							&& ((JButton) e.getSource()).location().x / 118 * 2 + 1 < 10)
						if (farm[cur_player][((JButton) e.getSource())
								.location().y / 110 * 2 + 1][((JButton) e
								.getSource()).location().x / 118 * 2 + 1]
								.isSquare()) {
							if (farm[cur_player][((JButton) e.getSource())
									.location().y / 110 * 2 + 1][((JButton) e
									.getSource()).location().x / 118 * 2 + 1]
									.getType() == 'e'
									|| farm[cur_player][((JButton) e
											.getSource()).location().y / 110 * 2 + 1][((JButton) e
											.getSource()).location().x / 118 * 2 + 1]
											.getType() == 'V'
									|| farm[cur_player][((JButton) e
											.getSource()).location().y / 110 * 2 + 1][((JButton) e
											.getSource()).location().x / 118 * 2 + 1]
											.getType() == 'h'
									|| farm[cur_player][((JButton) e
											.getSource()).location().y / 110 * 2 + 1][((JButton) e
											.getSource()).location().x / 118 * 2 + 1]
											.getType() == 'p') {

								players[cur_player].addStable(1);
								if (farm[cur_player][((JButton) e.getSource())
										.location().y / 110 * 2 + 1][((JButton) e
										.getSource()).location().x / 118 * 2 + 1]
										.getType() != 'p')
									players[cur_player].decEmpty(1);
								players[cur_player].addWood(-2);

								farm[cur_player][((JButton) e.getSource())
										.location().y / 110 * 2 + 1][((JButton) e
										.getSource()).location().x / 118 * 2 + 1]
										.setType('s');
								playerupdate();
								updateFarm(false);

								Object stabdone[] = { "Build Room",
										"Build Stable", "Done Action" };

								int selectedValue = JOptionPane
										.showOptionDialog(null,
												"Choose Action", "Choose one",
												JOptionPane.DEFAULT_OPTION,
												JOptionPane.PLAIN_MESSAGE,
												null, stabdone, stabdone[0]);

								if (selectedValue == 0) {

									if (players[cur_player].getReed() < 2) {
										players[cur_player].useFam();
										update(false);
										JOptionPane.showMessageDialog(null,
												"Not enough reed",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
									}

									else if (players[cur_player].getRoomType() == 'w') {
										if (players[cur_player].getWood() < 5) {

											JOptionPane.showMessageDialog(null,
													"Not enough wood",
													"insufficient resources",
													JOptionPane.ERROR_MESSAGE);
											players[cur_player].useFam();
											update(false);
										} else {

											wRoom = true;
											wStable = false;
										}

									}

									else if (players[cur_player].getRoomType() == 'c') {
										if (players[cur_player].getClay() < 5) {

											JOptionPane.showMessageDialog(null,
													"Not enough clay",
													"insufficient resources",
													JOptionPane.ERROR_MESSAGE);
											players[cur_player].useFam();
											update(false);
										} else {

											wRoom = true;
											wStable = false;
										}

									}

									else {
										if (players[cur_player].getStone() < 5) {
											players[cur_player].useFam();
											update(false);
											JOptionPane.showMessageDialog(null,
													"Not enough stone",
													"insufficient resources",
													JOptionPane.ERROR_MESSAGE);
										} else {

											wRoom = true;
											wStable = false;
										}

									}

								}

								else if (selectedValue == 1) {
									if (players[cur_player].getWood() < 2) {
										players[cur_player].useFam();
										update(false);
										JOptionPane.showMessageDialog(null,
												"Not enough wood",
												"insufficient resources",
												JOptionPane.ERROR_MESSAGE);
									} else {
										wRoom = false;
										wStable = true;
									}
								} else {

									players[cur_player].useFam();
									update(false);
								}

							}
						}
				}

				// improvement named value but this is the bake bread or build 1
				// stable action
				if (wStableRoom) {
					int tempCOven = 1;
					int tempSOven = 2;
					playerupdate();
					updateFarm(false);
					b_stable.setVisible(false);

					if (((JButton) e.getSource()).location().y / 110 * 2 + 1 < 6
							&& ((JButton) e.getSource()).location().x / 118 * 2 + 1 < 10)
						if (farm[cur_player][((JButton) e.getSource())
								.location().y / 110 * 2 + 1][((JButton) e
								.getSource()).location().x / 118 * 2 + 1]
								.isSquare()) {
							if (farm[cur_player][((JButton) e.getSource())
									.location().y / 110 * 2 + 1][((JButton) e
									.getSource()).location().x / 118 * 2 + 1]
									.getType() == 'e'
									|| farm[cur_player][((JButton) e
											.getSource()).location().y / 110 * 2 + 1][((JButton) e
											.getSource()).location().x / 118 * 2 + 1]
											.getType() == 'V'
									|| farm[cur_player][((JButton) e
											.getSource()).location().y / 110 * 2 + 1][((JButton) e
											.getSource()).location().x / 118 * 2 + 1]
											.getType() == 'p'
									|| farm[cur_player][((JButton) e
											.getSource()).location().y / 110 * 2 + 1][((JButton) e
											.getSource()).location().x / 118 * 2 + 1]
											.getType() == 'h') {

								farm[cur_player][((JButton) e.getSource())
										.location().y / 110 * 2 + 1][((JButton) e
										.getSource()).location().x / 118 * 2 + 1]
										.setType('s');
								players[cur_player].addStable(1);
								if (farm[cur_player][((JButton) e.getSource())
										.location().y / 110 * 2 + 1][((JButton) e
										.getSource()).location().x / 118 * 2 + 1]
										.getType() != 'p')
									players[cur_player].decEmpty(1);
								players[cur_player].addWood(-1);
								wStableRoom = false;

								Object breadstab[] = { "Bake Bread",
										"Done Action" };
								int selectedValue = 0;
								while (selectedValue == 0) {

									selectedValue = JOptionPane
											.showOptionDialog(null,
													"Choose Action",
													"Choose one",
													JOptionPane.DEFAULT_OPTION,
													JOptionPane.PLAIN_MESSAGE,
													null, breadstab,
													breadstab[0]);

									if (selectedValue == 0) {
										if (players[cur_player].getGrain() > 0) {

											if (players[cur_player].hasCOven()
													&& tempCOven > 0) {
												tempCOven--;
												players[cur_player].addFood(5);
												players[cur_player]
														.addGrain(-1);
											} else if (players[cur_player]
													.hasSOven()
													&& tempSOven > 0) {
												tempSOven--;
												players[cur_player].addFood(4);
												players[cur_player]
														.addGrain(-1);
											} else if (players[cur_player]
													.hasHearth()) {
												players[cur_player].addFood(3);
												players[cur_player]
														.addGrain(-1);
											} else if (players[cur_player]
													.hasFireplace()) {
												players[cur_player].addFood(2);
												players[cur_player]
														.addGrain(-1);
											} else
												JOptionPane
														.showMessageDialog(
																null,
																"You do not have a Hearth/Fireplace or you already used your oven's action!",
																"insufficient resources",
																JOptionPane.ERROR_MESSAGE);

										} else
											JOptionPane
													.showMessageDialog(
															null,
															"You have no grain to bake!",
															"insufficient resources",
															JOptionPane.ERROR_MESSAGE);

									} else {
										players[cur_player].useFam();
										update(false);
									}
								}
							}
						}
				}

				// 2nd way to plow a field
				if (wField2) {
					if (((JButton) e.getSource()).location().y / 110 * 2 + 1 < 6
							&& ((JButton) e.getSource()).location().x / 118 * 2 + 1 < 10)
						if (farm[cur_player][((JButton) e.getSource())
								.location().y / 110 * 2 + 1][((JButton) e
								.getSource()).location().x / 118 * 2 + 1]
								.getType() == 'e'
								&& farm[cur_player][((JButton) e.getSource())
										.location().y / 110 * 2 + 1][((JButton) e
										.getSource()).location().x / 118 * 2 + 1]
										.isSquare()) {

							b_fieldsow.setVisible(false);
							players[cur_player].useFam();
							players[cur_player].decEmpty(1);

							players[cur_player].addField();

							farm[cur_player][((JButton) e.getSource())
									.location().y / 110 * 2 + 1][((JButton) e
									.getSource()).location().x / 118 * 2 + 1]
									.setType('f');
							updateFarm(false);

							Object plowchoice[] = { "Sow Grain",
									"Sow Vegetable", "Done Action" };
							boolean tempcontinue;
							int selectedValue = 0;
							while (selectedValue != 2) {

								selectedValue = JOptionPane.showOptionDialog(
										null, "Choose Action", "Choose one",
										JOptionPane.DEFAULT_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										plowchoice, plowchoice[0]);

								if (selectedValue == 0) {
									tempcontinue = true;
									if (players[cur_player].getGrain() > 0) {

										for (int r = 0; r < 7; r++) {
											for (int col = 0; col < 11; col++) {

												if (farm[cur_player][r][col]
														.getType() == 'f'
														&& farm[cur_player][r][col]
																.getStack() == 0
														&& tempcontinue) {
													farm[cur_player][r][col]
															.setStack(3);
													farm[cur_player][r][col]
															.setType('g');
													players[cur_player]
															.decGrain();
													tempcontinue = false;
													playerupdate();
													updateFarm(false);
												}
											}
										}
										if (tempcontinue) {
											JOptionPane
													.showMessageDialog(
															null,
															"You do not have any space in your field left!",
															"No Space",
															JOptionPane.ERROR_MESSAGE);
										}
									} else {
										JOptionPane
												.showMessageDialog(
														null,
														"You do not have any grain left!",
														"No Grain",
														JOptionPane.ERROR_MESSAGE);
									}

								} else if (selectedValue == 1) {
									tempcontinue = true;
									if (players[cur_player].getVege() > 0) {

										for (int r = 0; r < 7; r++) {
											for (int col = 0; col < 11; col++) {

												if (farm[cur_player][r][col]
														.getType() == 'f'
														&& farm[cur_player][r][col]
																.getStack() == 0
														&& tempcontinue) {
													farm[cur_player][r][col]
															.setStack(2);
													farm[cur_player][r][col]
															.setType('v');
													players[cur_player]
															.decVege();
													tempcontinue = false;
													playerupdate();
													updateFarm(false);
												}
											}
										}
										if (tempcontinue) {
											JOptionPane
													.showMessageDialog(
															null,
															"You do not have any space in your field left!",
															"No Space",
															JOptionPane.ERROR_MESSAGE);
										}
									} else
										JOptionPane
												.showMessageDialog(
														null,
														"You do not have any vegetables left!",
														"No Vegetables",
														JOptionPane.ERROR_MESSAGE);

								}

							}
							update(false);
						} else {
							wField2 = false;
						}

				}

			}

		}
		// changing the viewed player from the dropdown menu
		else {

			if (e.getActionCommand().equals("Player 1")) {
				view_player = 0;
				updateFarm(false);
				playerupdate();
			} else if (e.getActionCommand().equals("Player 2")) {
				view_player = 1;
				updateFarm(false);
				playerupdate();
			} else if (e.getActionCommand().equals("Player 3")) {
				view_player = 2;
				updateFarm(false);
				playerupdate();
			} else if (e.getActionCommand().equals("Player 4")) {
				view_player = 3;
				updateFarm(false);
				playerupdate();
			} else if (e.getActionCommand().equals("Player 5")) {
				view_player = 4;
				updateFarm(false);
				playerupdate();
			}
			view.getGameTexts()[12].setText(Integer.toString(view_player + 1));
		}

	}

	// ******************************************
	// playerupdate basically is only changing the displayed information of the
	// viewing player, since the user can change which farm/player info he is
	// viewing
	// this function is also called automatically when a new round begins
	// ******************************************

	public void playerupdate() {

		if (view_player == 0)
			view.getPlayer1().setSelected(true);
		else if (view_player == 1)
			view.getPlayer2().setSelected(true);
		else if (view_player == 2)
			view.getPlayer3().setSelected(true);
		else if (view_player == 3)
			view.getPlayer4().setSelected(true);
		else
			view.getPlayer5().setSelected(true);

		view.getPlayerTexts()[0].setText(Integer.toString(players[view_player]
				.getFood()));
		view.getPlayerTexts()[1].setText(Integer.toString(players[view_player]
				.getReed()));
		view.getPlayerTexts()[2].setText(Integer.toString(players[view_player]
				.getWood()));
		view.getPlayerTexts()[3].setText(Integer.toString(players[view_player]
				.getClay()));
		view.getPlayerTexts()[4].setText(Integer.toString(players[view_player]
				.getStone()));
		view.getPlayerTexts()[5].setText(Integer.toString(players[view_player]
				.getGrain()));
		view.getPlayerTexts()[6].setText(Integer.toString(players[view_player]
				.getVege()));
		view.getPlayerTexts()[7].setText(Integer.toString(players[view_player]
				.getFamily()));
		view.getPlayerTexts()[8].setText(Integer.toString(players[view_player]
				.getActiveFamily()));
		view.getPlayerTexts()[9].setText(Integer.toString(players[view_player]
				.getSheep()));
		view.getPlayerTexts()[10].setText(Integer.toString(players[view_player]
				.getBoar()));
		view.getPlayerTexts()[11].setText(Integer.toString(players[view_player]
				.getCattle()));
		view.getPlayerTexts()[12].setText(Integer.toString(players[view_player]
				.getRemainingSpace()));

		for (int k = 0; k < 10; k++)
			view.getPlayerImprovements()[k].setVisible(false);

		if (players[view_player].hasFireplace())
			view.getPlayerImprovements()[0].setVisible(true);
		if (players[view_player].hasFireplace2())
			view.getPlayerImprovements()[1].setVisible(true);
		if (players[view_player].hasHearth())
			view.getPlayerImprovements()[2].setVisible(true);
		// if (players[view_player].hasHearth())
		// view.getPlayerImprovements()[3].setVisible(true);
		if (players[view_player].hasCOven())
			view.getPlayerImprovements()[4].setVisible(true);
		if (players[view_player].hasSOven())
			view.getPlayerImprovements()[5].setVisible(true);
		if (players[view_player].hasJoinery())
			view.getPlayerImprovements()[6].setVisible(true);
		if (players[view_player].hasPottery())
			view.getPlayerImprovements()[7].setVisible(true);
		if (players[view_player].hasBasket())
			view.getPlayerImprovements()[8].setVisible(true);
		if (players[view_player].getWell() > 0)
			view.getPlayerImprovements()[9].setVisible(true);

	}

	public int getPlayers() {

		return num_players;
	}

	// ******************************************
	// After every action, update is called to change players and process new
	// round changes if everyone is out of family members
	// ******************************************

	public void update(boolean newround) {
		if (turn <= 14) {

			Object runaway[] = { "Convert Sheep", "Convert Boar",
					"Convert Cattle" };
			int selectedVal;
			while (players[cur_player].getRemainingSpace() < 0) {

				if (players[cur_player].isHuman()) {

					// animals run off if the player has no space in their farm
					selectedVal = JOptionPane
							.showOptionDialog(
									null,
									"You have more animals than you have space, you must convert them (if you have no oven they will simply run away immediately)",
									"Convert Animals",
									JOptionPane.DEFAULT_OPTION,
									JOptionPane.PLAIN_MESSAGE, null, runaway,
									runaway[0]);

					if (selectedVal == 0) {
						if (players[cur_player].getSheep() > 0) {

							players[cur_player].addSheep(-1);
							if (players[cur_player].hasHearth()
									|| players[cur_player].hasFireplace())
								players[cur_player].addFood(2);
						}
					} else if (selectedVal == 1) {
						if (players[cur_player].getBoar() > 0) {

							players[cur_player].addBoar(-1);
							if (players[cur_player].hasHearth())
								players[cur_player].addFood(3);
							else if (players[cur_player].hasFireplace())
								players[cur_player].addFood(2);
						}
					} else {
						if (players[cur_player].getCattle() > 0) {

							players[cur_player].addCattle(-1);
							if (players[cur_player].hasHearth())
								players[cur_player].addFood(4);
							else if (players[cur_player].hasFireplace())
								players[cur_player].addFood(3);
						}
					}
				} else {
					if (players[cur_player].getSheep() > 0) {
						players[cur_player].addSheep(-1);
						if (players[cur_player].hasHearth()
								|| players[cur_player].hasFireplace())
							players[cur_player].addFood(2);
					}

					else if (players[cur_player].getBoar() > 0) {

						players[cur_player].addBoar(-1);
						if (players[cur_player].hasHearth())
							players[cur_player].addFood(3);
						else if (players[cur_player].hasFireplace())
							players[cur_player].addFood(2);
					}

					else if (players[cur_player].getCattle() > 0) {

						players[cur_player].addCattle(-1);
						if (players[cur_player].hasHearth())
							players[cur_player].addFood(4);
						else if (players[cur_player].hasFireplace())
							players[cur_player].addFood(3);
					}

				}

			}
			// resetting any follow up commands (the user can click on a
			// different action without finishing a follow up command so it much
			// be cancelled)
			b_finish.setVisible(false);
			wStableRoom = false;
			wStable = false;
			wField = false;
			wRoom = false;
			wRoom2 = false;
			wSow = false;
			wFieldSow = false;
			wFences = false;
			wFences2 = false;
			extraFences = false;
			wSheep = false;
			wBoar = false;
			wCattle = false;
			wRoom5p = false;

			int sum = 0;
			for (int i = 0; i < num_players; i++)
				sum += players[i].getActiveFamily();

			// if no one has any family members with actions left
			if (sum == 0) {

				// harvest turns
				if (turn == 4 || turn == 7 || turn == 9 || turn == 11
						|| turn == 13 || turn == 14) {
					for (int p = 0; p < num_players; p++) {
						if (players[p].getWell() > 0) {
							players[p].decWell();
							players[p].addFood(1);
						}
						view_player = p;
						// cycles through the players to process harvest phases

						for (int r = 0; r < 7; r++) {
							for (int col = 0; col < 11; col++) {

								// field phase - gives the player 1 grain or 1
								// vegetables on all their planted fields
								if (farm[p][r][col].getType() == 'g'
										&& farm[p][r][col].getStack() >= 1) {
									farm[p][r][col].decStack();
									if (farm[p][r][col].getStack() == 0)
										farm[p][r][col].setType('f');
									players[p].addGrain(1);
								}
								if (farm[p][r][col].getType() == 'v'
										&& farm[p][r][col].getStack() >= 1) {
									farm[p][r][col].decStack();
									if (farm[p][r][col].getStack() == 0)
										farm[p][r][col].setType('f');
									players[p].addVege();
								}
							}
						}

						// food processing part, gives the user a chance to
						// convert food to acheive the required 2 food per
						// family member (3 in a 1p game)
						// computers move on to their harvest algorithm, players
						// are given a choice
						if (players[p].isHuman()) {

							int selectedValue = 0;
							Object harvestopt[] = { "Convert Grain",
									"Convert Vegetable", "Convert Sheep",
									"Convert Boar", "Convert Cattle",
									"Convert Wood", "Convert Clay",
									"Convert Reed", "Done" };

							while (selectedValue != 8) {
								playerupdate();
								updateFarm(false);
								if (num_players == 1) {
									selectedValue = JOptionPane
											.showOptionDialog(
													null,
													"Choose actions before Harvest, 3 food per family member (or 1 per newborn) is required to not receive a score deduction.\nWithout baking bread, grain always converts to 1 food.  \nWithout a fireplace or cooking hearth, you may only convert vegetables at 1 food each, animals must be converted with a fireplace or cooking hearth.  \nWood, Clay, and Reed can only be converted with their specific improvmenet",
													"Harvest",
													JOptionPane.DEFAULT_OPTION,
													JOptionPane.PLAIN_MESSAGE,
													null, harvestopt,
													harvestopt[0]);
								} else {

									selectedValue = JOptionPane
											.showOptionDialog(
													null,
													"Choose actions before Harvest, 2 food per family member (or 1 per newborn) is required to not receive a score deduction.\nWithout baking bread, grain always converts to 1 food.  \nWithout a fireplace or cooking hearth, you may only convert vegetables at 1 food each, animals must be converted with a fireplace or cooking hearth.  \nWood, Clay, and Reed can only be converted with their specific improvmenet",
													"Harvest",
													JOptionPane.DEFAULT_OPTION,
													JOptionPane.PLAIN_MESSAGE,
													null, harvestopt,
													harvestopt[0]);
								}
								if (selectedValue == 0
										&& players[p].getGrain() > 0) {
									players[p].decGrain();
									players[p].addFood(1);
								} else if (selectedValue == 1
										&& players[p].getVege() > 0) {
									players[p].decVege();
									if (players[p].hasHearth())
										players[p].addFood(3);

									else if (players[p].hasFireplace())
										players[p].addFood(2);

									else
										players[p].addFood(1);

								}

								else if (selectedValue == 2
										&& players[p].getSheep() > 0) {

									if (players[p].hasHearth()
											|| players[p].hasFireplace()) {
										players[p].addFood(2);
										players[p].addSheep(-1);
									}

									else

										JOptionPane
												.showMessageDialog(
														null,
														"You do not have a fireplace or cooking hearth!",
														"No improvement",
														JOptionPane.ERROR_MESSAGE);

								}

								else if (selectedValue == 3
										&& players[p].getBoar() > 0) {

									players[p].addBoar(-1);

									if (players[p].hasHearth())
										players[p].addFood(3);

									else if (players[p].hasFireplace())
										players[p].addFood(2);
									else

										JOptionPane
												.showMessageDialog(
														null,
														"You do not have a fireplace or cooking hearth!",
														"No Imrovement",
														JOptionPane.ERROR_MESSAGE);

								}

								else if (selectedValue == 4
										&& players[p].getCattle() > 0) {
									players[p].addCattle(-1);

									if (players[p].hasHearth())
										players[p].addFood(4);

									else if (players[p].hasFireplace())
										players[p].addFood(3);
									else

										JOptionPane
												.showMessageDialog(
														null,
														"You do not have a fireplace or cooking hearth!",
														"No Imrovement",
														JOptionPane.ERROR_MESSAGE);

								} else if (selectedValue == 5
										&& players[p].getWood() > 0) {
									if (players[p].hasJoinery()) {
										players[p].addWood(-1);
										players[p].addFood(2);
									} else
										JOptionPane.showMessageDialog(null,
												"You do not have a Joinery!",
												"No Improvement!",
												JOptionPane.ERROR_MESSAGE);
								} else if (selectedValue == 6
										&& players[p].getClay() > 0) {
									if (players[p].hasPottery()) {
										players[p].addClay(-1);
										players[p].addFood(2);
									} else
										JOptionPane.showMessageDialog(null,
												"You do not have a Pottery!",
												"No Improvement!",
												JOptionPane.ERROR_MESSAGE);
								} else if (selectedValue == 7
										&& players[p].getReed() > 0) {
									if (players[p].hasBasket()) {
										players[p].addReed(-1);
										players[p].addFood(3);
									} else
										JOptionPane
												.showMessageDialog(
														null,
														"You do not have a Basketmaker's Workshop!",
														"No Improvement!",
														JOptionPane.ERROR_MESSAGE);
								} else if (selectedValue != 8) {
									JOptionPane
											.showMessageDialog(
													null,
													"You do not have the required resource!",
													"Error",
													JOptionPane.ERROR_MESSAGE);
								}

							}
						}

						else
							computerHarvest(p);

						if (players[p].hasChild()) {
							players[p].addFood(1);
						}

						if (num_players > 1) {

							if (players[p].getFood() < players[p].getFamily() * 2) {
								players[p].addFood(-(players[p].getFood()));
								players[p]
										.addScore(-(((players[p].getFamily() * 2) - players[p]
												.getFood()) * 3));

							} else
								players[p]
										.addFood(-(players[p].getFamily() * 2));
						} else {
							if (players[p].getFood() < players[p].getFamily() * 3) {
								players[p].addFood(-(players[p].getFood()));
								players[p]
										.addScore(-(((players[p].getFamily() * 3) - players[p]
												.getFood()) * 3));

							} else
								players[p]
										.addFood(-(players[p].getFamily() * 3));

						}
						// animals reproduce if there are at least 2 of them and
						// there is space (each animal only gets max 1 more per
						// game rules)
						if (players[p].getSpace() > 0) {
							if (players[p].getCattle() >= 2)
								players[p].addCattle(1);
							if (players[p].getBoar() >= 2)
								players[p].addBoar(1);
							if (players[p].getSheep() >= 2)
								players[p].addSheep(1);
						}
						if (turn == 14) {

							players[p].calcScore();

						}

					}
					// final turn, calculate the scores
					if (turn == 14) {

						playerupdate();
						if (num_players == 1) {

							JOptionPane.showMessageDialog(null, "Final Score: "
									+ players[0].getScore());
						}

						if (num_players == 2) {

							JOptionPane.showMessageDialog(
									null,
									"Final Scores\nPlayer1: "
											+ players[0].getScore()
											+ "\nPlayer 2: "
											+ players[1].getScore());
						}
						if (num_players == 3) {

							JOptionPane.showMessageDialog(
									null,
									"Final Scores\nPlayer1: "
											+ players[0].getScore()
											+ "\nPlayer 2: "
											+ players[1].getScore()
											+ "\nPlayer 3: "
											+ players[2].getScore());
						}
						if (num_players == 4) {

							JOptionPane.showMessageDialog(
									null,
									"Final Scores\nPlayer1: "
											+ players[0].getScore()
											+ "\nPlayer 2: "
											+ players[1].getScore()
											+ "\nPlayer 3: "
											+ players[2].getScore()
											+ "\nPlayer 4: "
											+ players[3].getScore());
						}
						if (num_players == 5) {

							JOptionPane.showMessageDialog(
									null,
									"Final Scores\nPlayer1: "
											+ players[0].getScore()
											+ "\nPlayer 2: "
											+ players[1].getScore()
											+ "\nPlayer 3: "
											+ players[2].getScore()
											+ "\nPlayer 4: "
											+ players[3].getScore()
											+ "\nPlayer 5: "
											+ players[4].getScore());
						}

					}

				}

				// increment stacking game resource values, some only incrememnt
				// when their respective button shows up in rounds
				if (turn > 4)
					stone++;

				if (turn > 7)
					boar++;

				if (turn > 9)
					cattle++;

				if (turn > 10)
					stone2++;

				turn++;
				if (num_players == 1)
					wood += 2;
				else
					wood += 3;
				clay++;
				reed++;
				food++;
				sheep++;
				clay_3p++;
				wood2_3p += 2;
				wood_4p++;
				wood2_4p += 2;
				clay2_4p += 2;
				food_4p++;
				wood4_5p += 4;
				clay3_5p += 3;
				food_5p++;
				reed_5p++;

				// if a player has a newborn, new round starts and it is now a
				// full family member
				for (int i = 0; i < num_players; i++) {
					players[i].resetFam();
					if (players[i].hasChild())
						players[i].setChild();
				}

				// start players can change so a new round sets the first currnt
				// player to the start player
				cur_player = start_player;
				if (num_players == 3) {
					b3_2wood.setVisible(true);
					b3_clay.setVisible(true);
					b3_resource.setVisible(true);
					b3_resource2.setVisible(true);
				} else if (num_players == 4) {
					b4_2clay.setVisible(true);
					b4_2wood.setVisible(true);
					b4_3resource.setVisible(true);
					b4_resource.setVisible(true);
					b4_food.setVisible(true);
					b4_wood.setVisible(true);

				} else if (num_players == 5) {
					b5_3clay.setVisible(true);
					b5_4wood.setVisible(true);
					b5_resource.setVisible(true);
					b5_roomfood.setVisible(true);
					b5_animals.setVisible(true);
					b5_reed.setVisible(true);
				}
				// resetting the visibility on buttons
				b_room.setVisible(true);
				b_start.setVisible(true);
				b_grain.setVisible(true);
				b_field.setVisible(true);
				b_stable.setVisible(true);
				b_day.setVisible(true);
				b_wood.setVisible(true);
				b_clay.setVisible(true);
				b_reed.setVisible(true);
				b_food.setVisible(true);
				b_sheep.setVisible(true);
				if (turn > 1)
					b_sow.setVisible(true);
				if (turn > 2)
					b_fences.setVisible(true);
				if (turn > 3)
					b_improve.setVisible(true);
				if (turn > 4) {
					view.getGameTexts()[6].setVisible(true);
					b_stone.setVisible(true);
				}
				if (turn > 5)
					b_growth.setVisible(true);
				if (turn > 6)
					b_renov.setVisible(true);
				if (turn > 7) {
					view.getGameTexts()[7].setVisible(true);
					b_boar.setVisible(true);
				}
				if (turn > 8)
					b_vege.setVisible(true);
				if (turn > 9) {
					view.getGameTexts()[8].setVisible(true);
					b_cattle.setVisible(true);
				}
				if (turn > 10) {
					view.getGameTexts()[9].setVisible(true);
					b_stone2.setVisible(true);
				}
				if (turn > 11)
					b_growth2.setVisible(true);

				if (turn > 12)
					b_fieldsow.setVisible(true);

				if (turn > 13)
					b_renov2.setVisible(true);
			}

			// no new round beings, makes the next player the current player,
			// skips them if they have no remaining family members
			else {

				cur_player++;
				if (cur_player == num_players)
					cur_player = 0;
				while (players[cur_player].getActiveFamily() <= 0) {
					cur_player++;
					if (cur_player == num_players)
						cur_player = 0;
				}
			}

			view_player = cur_player;

			playerupdate();

			// tells the view to update the game texts
			view.getGameTexts()[0].setText(Integer.toString(turn));
			view.getGameTexts()[1].setText(Integer.toString(wood));
			view.getGameTexts()[2].setText(Integer.toString(clay));
			view.getGameTexts()[3].setText(Integer.toString(reed));
			view.getGameTexts()[4].setText(Integer.toString(food));
			view.getGameTexts()[5].setText(Integer.toString(sheep));
			view.getGameTexts()[6].setText(Integer.toString(stone));
			view.getGameTexts()[7].setText(Integer.toString(boar));
			view.getGameTexts()[8].setText(Integer.toString(cattle));
			view.getGameTexts()[9].setText(Integer.toString(stone2));
			view.getGameTexts()[10].setText(Integer.toString(cur_player + 1));
			view.getGameTexts()[11].setText(Integer.toString(start_player + 1));
			view.getGameTexts()[12].setText(Integer.toString(view_player + 1));

			if (num_players == 3) {

				view.get3Texts()[0].setText(Integer.toString(wood2_3p));
				view.get3Texts()[1].setText(Integer.toString(clay_3p));
			} else if (num_players == 4) {
				view.get4Texts()[0].setText(Integer.toString(wood_4p));
				view.get4Texts()[1].setText(Integer.toString(wood2_4p));
				view.get4Texts()[2].setText(Integer.toString(clay2_4p));
				view.get4Texts()[3].setText(Integer.toString(food_4p));
			} else if (num_players == 5) {

				view.get5Texts()[0].setText(Integer.toString(reed_5p));
				view.get5Texts()[1].setText(Integer.toString(food_5p));
				view.get5Texts()[2].setText(Integer.toString(clay3_5p));
				view.get5Texts()[3].setText(Integer.toString(wood4_5p));
			}

			updateFarm(false);

			if (!players[cur_player].isHuman())
				computerTurn();

		}
		
		//Update Button tooltips
		displaySpaceTypes();
		
	}

	// **************************
	// When any visual changes on the displayed farm need to be done
	// **************************
	public void updateFarm(boolean alter) {

		if (alter) {

		}

		else {
			for (int r = 0; r < 7; r++) {
				for (int col = 0; col < 11; col++) {
					// e= empty, w=wood room, p=pasture, c=clay room, s=stone
					// room, f=field, g=grain field, v=vege field, x=fence

					if (farm[view_player][r][col].getType() == 'e') {

						if (!farm[view_player][r][col].isSquare()
								&& farm[view_player][r][col].isValid())
							b[r][col].setBackground(Color.cyan);
						else
							b[r][col].setBackground(Color.white);
					} else if (farm[view_player][r][col].getType() == 'w')
						b[r][col].setBackground(new Color(139, 69, 19));
					else if (farm[view_player][r][col].getType() == 'c')
						b[r][col].setBackground(Color.red);
					else if (farm[view_player][r][col].getType() == 's')
						b[r][col].setBackground(new Color(0, 0, 139));
					else if (farm[view_player][r][col].getType() == 't')
						b[r][col].setBackground(new Color(112, 128, 144));
					else if (farm[view_player][r][col].getType() == 'p') {
						b[r][col].setBackground(new Color(135, 206, 250));
					} else if (farm[view_player][r][col].getType() == 'g') {
						if (farm[view_player][r][col].getStack() == 1)
							b[r][col].setBackground(new Color(238, 232, 170));
						else if (farm[view_player][r][col].getStack() == 2)
							b[r][col].setBackground(Color.yellow);
						else
							b[r][col].setBackground(new Color(255, 215, 0));
					} else if (farm[view_player][r][col].getType() == 'v') {
						if (farm[view_player][r][col].getStack() == 2)
							b[r][col].setBackground(Color.green);
						else
							b[r][col].setBackground(new Color(152, 251, 152));
					} else if (farm[view_player][r][col].getType() == 'f')
						b[r][col].setBackground(new Color(128, 128, 0));
					else if (farm[view_player][r][col].getType() == 'x')
						b[r][col].setBackground(new Color(205, 133, 63));

				}

			}
		}

	}

	// process a computer turn
	public void computerTurn() {

		int num = 0;
		int maxVal = 0;
		int tempVal = 0;
		int eVal = 0;

		if (b_room.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(1, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(1, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 1;
			}

		}

		if (b_start.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(2, cur_player);
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 2;
			}

		}

		if (b_grain.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(3, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(3, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 3;
			}

		}

		if (b_field.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(4, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(4, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 4;
			}

		}

		if (b_stable.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(5, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(5, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 5;
			}

		}

		if (b_day.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(6, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(6, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 6;
			}

		}

		if (b_wood.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(7, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(7, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 7;
			}

		}

		if (b_clay.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(8, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(8, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 8;
			}

		}

		if (b_reed.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(9, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(9, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 9;
			}

		}

		if (b_food.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(10, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(10, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 10;
			}

		}

		if (b_sheep.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(11, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(11, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 11;
			}

		}

		if (b_sow.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(12, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(12, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 12;
			}

		}

		if (b_fences.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(13, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(13, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 13;
			}

		}

		if (b_improve.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(14, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(14, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 14;
			}

		}

		if (b_stone.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(15, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(15, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 15;
			}

		}

		if (b_growth.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(16, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(16, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 16;
			}

		}

		if (b_renov.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(17, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(17, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 17;
			}

		}

		if (b_boar.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(18, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(18, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 18;
			}

		}

		if (b_vege.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(19, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(19, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 19;
			}

		}

		if (b_cattle.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(20, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(20, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 20;
			}

		}

		if (b_stone2.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(21, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(21, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 21;
			}

		}

		if (b_growth2.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(22, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(22, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 22;
			}

		}

		if (b_fieldsow.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(20, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(23, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 23;
			}

		}

		if (b_renov2.isVisible()) {
			tempVal = 0;
			eVal = 0;
			tempVal = determineValues(24, cur_player);
			if (players[cur_player].isHard()) {
				tempVal = determineValues(24, (cur_player + 1) % num_players);

				if (eVal >= tempVal)
					tempVal++;
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
				num = 24;
			}

		}

		if (num_players == 3) {
			if (b3_clay.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(25, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(25, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 25;
				}

			}

			if (b3_2wood.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(26, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(26, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 26;
				}

			}

			if (b3_resource.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(25, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(27, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 27;
				}

			}

			if (b3_resource2.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(28, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(28, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 28;
				}

			}
		}

		else if (num_players == 4) {
			if (b4_wood.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(29, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(29, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 29;
				}

			}
			if (b4_2clay.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(30, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(30, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 30;
				}

			}

			if (b4_2wood.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(31, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(31, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 31;
				}

			}

			if (b4_food.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(32, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(32, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 32;
				}

			}

			if (b4_resource.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(33, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(33, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 313;
				}

			}

			if (b4_3resource.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(34, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(34, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 34;
				}

			}

		}

		else if (num_players == 5) {
			if (b5_4wood.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(35, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(35, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 35;
				}

			}

			if (b5_3clay.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(36, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(36, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 36;
				}

			}

			if (b5_roomfood.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(37, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(37, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 37;
				}

			}

			if (b5_reed.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(38, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(38, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 38;
				}

			}

			if (b5_animals.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(39, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(39, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 39;
				}

			}

			if (b5_resource.isVisible()) {
				tempVal = 0;
				eVal = 0;
				tempVal = determineValues(40, cur_player);
				if (players[cur_player].isHard()) {
					tempVal = determineValues(40, (cur_player + 1)
							% num_players);

					if (eVal >= tempVal)
						tempVal++;
				}
				if (tempVal > maxVal) {
					maxVal = tempVal;
					num = 40;
				}
			}
		}

		if (num == 1) {// build rooms and stables
			b_room.setVisible(false);
			for (int r = 6; r >= 0; r--) {
				for (int col = 0; col < 11; col++) {

					if (farm[cur_player][r][col].getType() == 'e'
							&& farm[cur_player][r][col].isSquare()) {
						if (players[cur_player].getRoomType() == 'w') {
							if (players[cur_player].getWood() >= 5
									&& players[cur_player].getReed() >= 2) {

								farm[cur_player][r][col].setType('w');
								players[cur_player].addWood(-5);
								players[cur_player].addReed(-2);
								players[cur_player].addRooms(1);
								players[cur_player].decEmpty(1);
							} else if (players[cur_player].getClay() >= 5
									&& players[cur_player].getReed() >= 2) {

								farm[cur_player][r][col].setType('c');
								players[cur_player].addClay(-5);
								players[cur_player].addReed(-2);
								players[cur_player].addRooms(1);
								players[cur_player].decEmpty(1);
							} else if (players[cur_player].getStone() >= 5
									&& players[cur_player].getReed() >= 2) {

								farm[cur_player][r][col].setType('t');
								players[cur_player].addStone(-5);
								players[cur_player].addReed(-2);
								players[cur_player].addRooms(1);
								players[cur_player].decEmpty(1);
							}

						}
					}
				}
			}

			for (int r = 6; r >= 0; r--) {
				for (int col = 10; col >= 0; col--) {
					if (players[cur_player].getWood() >= 2
							&& players[cur_player].getStable() < 4
							&& farm[cur_player][r][col].isSquare()) {

						if (farm[cur_player][r][col].getType() == 'p'
								|| farm[cur_player][r][col].getType() == 'V'
								|| farm[cur_player][r][col].getType() == 'h'
								|| farm[cur_player][r][col].getType() == 'e') {
							if (farm[cur_player][r][col].getType() != 'p')
								players[cur_player].decEmpty(1);
							farm[cur_player][r][col].setType('s');
							players[cur_player].addWood(-2);
							players[cur_player].addStable(1);
						}
					}
				}
			}
		}

		else if (num == 2) {// starting player
			b_start.setVisible(false);
			players[cur_player].addFood(1);
			start_player = cur_player;

		}

		else if (num == 3) {// take grain
			b_grain.setVisible(false);
			players[cur_player].addGrain(1);

		}

		else if (num == 4) {// plow field
			boolean tempcont = true;

			b_field.setVisible(false);
			for (int r = 0; r < 7; r++) {
				for (int col = 10; col >= 0; col--) {
					if (farm[cur_player][r][col].getType() == 'e'
							&& farm[cur_player][r][col].isSquare() && tempcont) {
						farm[cur_player][r][col].setType('f');
						players[cur_player].addField();
						players[cur_player].decEmpty(1);
						tempcont = false;
					}
				}
			}

		} else if (num == 5) {// stable and bake bread
			boolean tempcont = true;
			for (int r = 6; r >= 0; r--) {
				for (int col = 10; col >= 0; col--) {
					if (players[cur_player].getWood() >= 1
							&& players[cur_player].getStable() < 4 && tempcont
							&& farm[cur_player][r][col].isSquare()) {

						if (farm[cur_player][r][col].getType() == 'p'
								|| farm[cur_player][r][col].getType() == 'V'
								|| farm[cur_player][r][col].getType() == 'h'
								|| farm[cur_player][r][col].getType() == 'e') {
							if (farm[cur_player][r][col].getType() != 'p')
								players[cur_player].decEmpty(1);
							farm[cur_player][r][col].setType('s');
							players[cur_player].addWood(-1);
							players[cur_player].addStable(1);
							tempcont = false;
						}
					}
				}
			}
			boolean tempc = true;
			int tempCOven = 1;
			int tempSOven = 2;
			while (players[cur_player].getGrain() > 0 && tempc) {
				if (players[cur_player].hasCOven() && tempCOven > 0) {
					tempCOven--;
					players[cur_player].addFood(5);
					players[cur_player].addGrain(-1);
				} else if (players[cur_player].hasSOven() && tempSOven > 0) {
					tempSOven--;
					players[cur_player].addFood(4);
					players[cur_player].addGrain(-1);
				} else if (players[cur_player].hasHearth()) {
					players[cur_player].addFood(3);
					players[cur_player].addGrain(-1);
				} else if (players[cur_player].hasFireplace()) {
					players[cur_player].addFood(2);
					players[cur_player].addGrain(-1);
				} else {
					tempc = false;
				}
			}

		}

		else if (num == 6) {// day laborer
			b_day.setVisible(false);
			players[cur_player].addFood(1);
			if (players[cur_player].getStone() == 0)
				players[cur_player].addStone(1);
			else if (players[cur_player].getReed() == 0)
				players[cur_player].addReed(1);
			else if (players[cur_player].getClay() <= 1)
				players[cur_player].addClay(1);
			else if (players[cur_player].getWood() <= 1)
				players[cur_player].addWood(1);
			else
				players[cur_player].addStone(1);

		}

		else if (num == 7) {
			b_wood.setVisible(false);
			players[cur_player].addWood(wood);
			wood = 0;
		}

		else if (num == 8) {
			b_clay.setVisible(false);
			players[cur_player].addClay(clay);
			clay = 0;
		} else if (num == 9) {
			b_reed.setVisible(false);
			players[cur_player].addReed(reed);
			reed = 0;
		} else if (num == 10) {
			b_food.setVisible(false);
			players[cur_player].addFood(food);
			food = 0;
		} else if (num == 11) {// sheep
			b_sheep.setVisible(false);
			if (players[cur_player].getRemainingSpace() < sheep)
				players[cur_player].addSheep(players[cur_player]
						.getRemainingSpace());
			else
				players[cur_player].addSheep(sheep);
			sheep = 0;
		}

		else if (num == 12) {// sow and bake bread

			for (int r = 0; r < 7; r++) {
				for (int col = 0; col < 11; col++) {
					if (farm[cur_player][r][col].getType() == 'f'
							&& farm[cur_player][r][col].getStack() == 0) {
						if (players[cur_player].getVege() > 0) {
							farm[cur_player][r][col].setStack(2);
							farm[cur_player][r][col].setType('v');
							players[cur_player].decVege();
						} else if (players[cur_player].getGrain() > 0) {
							farm[cur_player][r][col].setStack(3);
							farm[cur_player][r][col].setType('g');
							players[cur_player].decGrain();
						}
					}
				}
			}

			boolean tempc = true;
			int tempCOven = 1;
			int tempSOven = 2;
			while (players[cur_player].getGrain() > 0 && tempc) {

				if (players[cur_player].hasCOven() && tempCOven > 0) {
					tempCOven--;
					players[cur_player].addFood(5);
					players[cur_player].addGrain(-1);
				} else if (players[cur_player].hasSOven() && tempSOven > 0) {
					tempSOven--;
					players[cur_player].addFood(4);
					players[cur_player].addGrain(-1);
				} else if (players[cur_player].hasHearth()) {
					players[cur_player].addFood(3);
					players[cur_player].addGrain(-1);
				} else if (players[cur_player].hasFireplace()) {
					players[cur_player].addFood(2);
					players[cur_player].addGrain(-1);
				} else {
					tempc = false;
				}
			}
		}

		else if (num == 13) {// fences
			b_fences.setVisible(false);
			int ac = 1;
			while (players[cur_player].getWood() > 1) {
				ac++;
				if (ac % 3 == 0) {
					players[cur_player].addPasture(1);
					players[cur_player].decEmpty(1);
				}
				players[cur_player].addWood(-1);
			}
		}

		else if (num == 14) {// major improvement, apologies for the formatting
			b_improve.setVisible(false);

			if (hearth_num > 0 && players[cur_player].hasFireplace()) {
				if (players[cur_player].hasFireplace2()) {

					players[cur_player].setFireplace2();
					view.getGameImprovements()[1].setVisible(true);
				} else {
					players[cur_player].setFireplace();
					view.getGameImprovements()[0].setVisible(true);
				}

				if (!players[cur_player].hasHearth())
					players[cur_player].setHearth();
				if (hearth_num == 2)
					view.getGameImprovements()[2].setVisible(false);

				else
					view.getGameImprovements()[3].setVisible(false);
				hearth_num--;
			} else if (hearth_num == 2 && players[cur_player].getClay() > 3) {

				players[cur_player].addScore(1);
				if (!players[cur_player].hasHearth())
					players[cur_player].setHearth();
				players[cur_player].addClay(-4);
				hearth_num--;
				view.getGameImprovements()[2].setVisible(false);
			}

			else if (hearth_num == 1 && players[cur_player].getClay() > 4) {
				players[cur_player].addScore(1);
				if (!players[cur_player].hasHearth())
					players[cur_player].setHearth();
				players[cur_player].addClay(-5);
				hearth_num--;
				view.getGameImprovements()[3].setVisible(false);

			}

			else if (clay_oven && players[cur_player].getClay() > 2
					&& players[cur_player].getStone() > 0) {
				players[cur_player].addScore(2);
				players[cur_player].setCOven();
				players[cur_player].addClay(-3);
				players[cur_player].addStone(-1);
				b_improve.setVisible(false);
				clay_oven = false;
				view.getGameImprovements()[4].setVisible(false);
			}

			else if (stone_oven && players[cur_player].getClay() > 0
					&& players[cur_player].getStone() > 2) {
				players[cur_player].addScore(3);
				players[cur_player].setSOven();
				players[cur_player].addClay(-1);
				players[cur_player].addStone(-3);
				view.getGameImprovements()[5].setVisible(false);
				stone_oven = false;

			}

			else if (fireplace_num == 2 && players[cur_player].getClay() > 1) {
				players[cur_player].addScore(1);
				if (players[cur_player].hasFireplace())
					players[cur_player].setFireplace2();
				else
					players[cur_player].setFireplace();
				players[cur_player].addClay(-2);
				fireplace_num--;
				view.getGameImprovements()[0].setVisible(false);

			} else if (fireplace_num == 1 && players[cur_player].getClay() > 2) {
				players[cur_player].addScore(1);
				if (players[cur_player].hasFireplace())
					players[cur_player].setFireplace2();
				else
					players[cur_player].setFireplace();
				players[cur_player].addClay(-3);
				fireplace_num--;
				view.getGameImprovements()[1].setVisible(false);

			}

			else if (wood_converter && players[cur_player].getWood() > 1
					&& players[cur_player].getStone() > 1) {

				players[cur_player].addScore(2);
				players[cur_player].setJoinery();
				players[cur_player].addWood(-2);
				players[cur_player].addStone(-2);
				view.getGameImprovements()[6].setVisible(false);
				wood_converter = false;

			}

			else if (clay_converter && players[cur_player].getClay() > 1
					&& players[cur_player].getStone() > 1) {
				players[cur_player].addScore(2);
				players[cur_player].setPottery();
				players[cur_player].addClay(-2);
				players[cur_player].addStone(-2);
				view.getGameImprovements()[7].setVisible(false);
				clay_converter = false;

			}

			else if (reed_converter && players[cur_player].getReed() > 1
					&& players[cur_player].getStone() > 1) {

				players[cur_player].addScore(2);
				players[cur_player].setBasket();
				players[cur_player].addReed(-2);
				players[cur_player].addStone(-2);
				reed_converter = false;
				view.getGameImprovements()[8].setVisible(false);
			}

			else if (well && players[cur_player].getWood() > 0
					&& players[cur_player].getStone() > 2) {
				players[cur_player].addScore(2);
				players[cur_player].setWell();
				players[cur_player].addWood(-1);
				players[cur_player].addStone(-3);
				well = false;
				view.getGameImprovements()[9].setVisible(false);

			}

		}

		else if (num == 15) {// stone
			b_stone.setVisible(false);
			players[cur_player].addStone(stone);
			stone = 0;
		}

		else if (num == 16) {// family growth
			if (players[cur_player].getRooms() >= players[cur_player]
					.getFamily()) {

				players[cur_player].addFamily();
				b_growth.setVisible(false);
			}
		}

		else if (num == 17) {// renovate
			if (players[cur_player].getReed() > 0) {
				if (farm[cur_player][3][1].getType() == 'w') {
					if (players[cur_player].getClay() < players[cur_player]
							.getRooms()) {
					} else {
						b_renov.setVisible(false);
						players[cur_player].setRoomType('c');
						players[cur_player].addClay(-(players[cur_player]
								.getRooms()));
						players[cur_player].addReed(-1);
						for (int r = 0; r < 7; r++) {
							for (int col = 0; col < 11; col++) {

								if (farm[cur_player][r][col].getType() == 'w')
									farm[cur_player][r][col].setType('c');
							}
						}
					}
				} else if (farm[cur_player][3][1].getType() == 'c') {
					if (players[cur_player].getStone() < players[cur_player]
							.getRooms()) {
					} else {
						b_renov.setVisible(false);
						players[cur_player].setRoomType('s');
						players[cur_player].addStone(-(players[cur_player]
								.getRooms()));
						players[cur_player].addReed(-1);
						for (int r = 0; r < 7; r++) {
							for (int col = 0; col < 11; col++) {

								if (farm[cur_player][r][col].getType() == 'c')
									farm[cur_player][r][col].setType('t');
							}

						}
					}
				}
			}
		}

		else if (num == 18) {// boar
			b_boar.setVisible(false);
			if (players[cur_player].getRemainingSpace() < boar)
				players[cur_player].addBoar(players[cur_player]
						.getRemainingSpace());
			else
				players[cur_player].addBoar(boar);
			boar = 0;
		}

		else if (num == 19) {// take vege
			b_vege.setVisible(false);
			players[cur_player].addVege();

		}

		else if (num == 20) {// take cattle
			b_cattle.setVisible(false);
			if (players[cur_player].getRemainingSpace() < cattle)
				players[cur_player].addCattle(players[cur_player]
						.getRemainingSpace());
			else
				players[cur_player].addCattle(cattle);
			cattle = 0;

		}

		else if (num == 21) {// take stone2
			b_stone2.setVisible(false);
			players[cur_player].addStone(stone2);
			stone2 = 0;

		}

		else if (num == 22) {// family growth 2
			b_growth2.setVisible(false);
			players[cur_player].addFamily();

		} else if (num == 23) {// plow and or sow
			b_fieldsow.setVisible(false);
			boolean tempcont = true;
			for (int r = 0; r < 7; r++) {
				for (int col = 10; col >= 0; col--) {
					if (farm[cur_player][r][col].getType() == 'e' && tempcont) {
						farm[cur_player][r][col].setType('p');
						players[cur_player].addField();
						players[cur_player].decEmpty(1);
						tempcont = false;
					}
				}
			}

			for (int r = 0; r < 7; r++) {
				for (int col = 0; col < 11; col++) {
					if (farm[cur_player][r][col].getType() == 'f'
							&& farm[cur_player][r][col].getStack() == 0) {
						if (players[cur_player].getVege() > 0) {
							farm[cur_player][r][col].setStack(2);
							farm[cur_player][r][col].setType('v');
							players[cur_player].decVege();
						} else if (players[cur_player].getGrain() > 0) {
							farm[cur_player][r][col].setStack(3);
							farm[cur_player][r][col].setType('g');
							players[cur_player].decGrain();
						}
					}
				}
			}

		}

		else if (num == 24) {// renovate and fences
			if (players[cur_player].getReed() > 0) {
				if (farm[cur_player][3][1].getType() == 'w') {
					if (players[cur_player].getClay() < players[cur_player]
							.getRooms()) {
					} else {
						b_renov2.setVisible(false);
						players[cur_player].setRoomType('c');
						players[cur_player].addClay(-(players[cur_player]
								.getRooms()));
						players[cur_player].addReed(-1);
						for (int r = 0; r < 7; r++) {
							for (int col = 0; col < 11; col++) {

								if (farm[cur_player][r][col].getType() == 'w')
									farm[cur_player][r][col].setType('c');
							}
						}
					}
				} else if (farm[cur_player][3][1].getType() == 'c') {
					if (players[cur_player].getStone() < players[cur_player]
							.getRooms()) {
					} else {
						b_renov2.setVisible(false);
						players[cur_player].setRoomType('s');
						players[cur_player].addStone(-(players[cur_player]
								.getRooms()));
						players[cur_player].addReed(-1);
						for (int r = 0; r < 7; r++) {
							for (int col = 0; col < 11; col++) {

								if (farm[cur_player][r][col].getType() == 'c')
									farm[cur_player][r][col].setType('t');
							}

						}
					}
				}
			}
			int ac = 1;
			while (players[cur_player].getWood() > 1) {
				ac++;
				if (ac % 3 == 0) {
					players[cur_player].addPasture(1);
					players[cur_player].decEmpty(1);
				}
				players[cur_player].addWood(-1);
			}
		}

		else if (num == 25) {// 3p clay
			b3_clay.setVisible(false);
			players[cur_player].addClay(clay_3p);
			clay_3p = 0;
		} else if (num == 26) {// 3p wood
			b3_2wood.setVisible(false);
			players[cur_player].addWood(wood2_3p);
			wood2_3p = 0;
		} else if (num == 27) {// 3p resource
			b3_resource.setVisible(false);
			if (players[cur_player].getStone() == 0)
				players[cur_player].addStone(1);
			else if (players[cur_player].getReed() == 0)
				players[cur_player].addReed(1);
			else if (players[cur_player].getClay() <= 1)
				players[cur_player].addClay(1);
			else if (players[cur_player].getWood() <= 1)
				players[cur_player].addWood(1);
			else
				players[cur_player].addStone(1);
		}

		else if (num == 28) {// 3p resource2
			b3_resource2.setVisible(false);
			players[cur_player].addStone(1);
			if (players[cur_player].getReed() <= 1)
				players[cur_player].addReed(1);
			else if (players[cur_player].getClay() <= 1)
				players[cur_player].addClay(1);
			else if (players[cur_player].getWood() <= 1)
				players[cur_player].addWood(1);
			else
				players[cur_player].addReed(1);

		}

		else if (num == 29) {// 4p wood
			b4_wood.setVisible(false);
			players[cur_player].addWood(wood_4p);
			wood_4p = 0;
		}

		else if (num == 30) {// 4p clay
			b4_2clay.setVisible(false);
			players[cur_player].addClay(clay2_4p);
			clay2_4p = 0;
		}

		else if (num == 31) {// 4p wood2
			b4_2wood.setVisible(false);
			players[cur_player].addWood(wood2_4p);
			wood2_4p = 0;
		}

		else if (num == 32) {// 4p food
			b4_food.setVisible(false);
			players[cur_player].addWood(food_4p);
			food_4p = 0;
		}

		else if (num == 33) {// 4p resource
			b4_resource.setVisible(false);
			players[cur_player].addStone(1);
			if (players[cur_player].getReed() <= 1)
				players[cur_player].addReed(1);
			else if (players[cur_player].getClay() <= 1)
				players[cur_player].addClay(1);
			else if (players[cur_player].getWood() <= 1)
				players[cur_player].addWood(1);
			else
				players[cur_player].addReed(1);

		}

		else if (num == 34) {// 4p 3 resources
			b4_3resource.setVisible(false);
			players[cur_player].addReed(1);
			players[cur_player].addStone(1);
			players[cur_player].addFood(1);
		}

		else if (num == 35) {// 5p wood
			b5_4wood.setVisible(false);
			players[cur_player].addWood(wood4_5p);
			wood4_5p = 0;
		} else if (num == 36) {// 5p clay
			b5_3clay.setVisible(false);
			players[cur_player].addClay(clay3_5p);
			clay3_5p = 0;
		} else if (num == 37) {// 5p room or take food
			b5_roomfood.setVisible(false);
			boolean tempcont = true;
			for (int r = 6; r >= 0; r--) {
				for (int col = 0; col < 11; col++) {

					if (farm[cur_player][r][col].getType() == 'e'
							&& farm[cur_player][r][col].isSquare() && tempcont) {
						if (players[cur_player].getRoomType() == 'w') {
							if (players[cur_player].getWood() >= 5
									&& players[cur_player].getReed() >= 2) {

								farm[cur_player][r][col].setType('w');
								players[cur_player].addWood(-5);
								players[cur_player].addReed(-2);
								players[cur_player].addRooms(1);
								players[cur_player].decEmpty(1);
								tempcont = false;
							} else if (players[cur_player].getClay() >= 5
									&& farm[cur_player][r][col].isSquare()
									&& players[cur_player].getReed() >= 2
									&& tempcont) {

								farm[cur_player][r][col].setType('c');
								players[cur_player].addClay(-5);
								players[cur_player].addReed(-2);
								players[cur_player].addRooms(1);
								players[cur_player].decEmpty(1);
								tempcont = false;
							} else if (players[cur_player].getStone() >= 5
									&& farm[cur_player][r][col].isSquare()
									&& players[cur_player].getReed() >= 2
									&& tempcont) {

								farm[cur_player][r][col].setType('t');
								players[cur_player].addStone(-5);
								players[cur_player].addReed(-2);
								players[cur_player].addRooms(1);
								players[cur_player].decEmpty(1);
								tempcont = false;
							}

						}
					}
				}
			}
			if (tempcont) {
				players[cur_player].addFood(food_5p);
				food_5p = 0;
			}
		}

		else if (num == 38) {// 5p reed and other resources
			b5_reed.setVisible(false);
			players[cur_player].addReed(reed_5p);
			players[cur_player].addStone(1);
			players[cur_player].addWood(1);
			reed_5p = 0;
		}

		else if (num == 39) {// 5p animals
			b5_animals.setVisible(false);
			if (players[cur_player].getBoar() < 2) {
				players[cur_player].addBoar(1);
			} else if (players[cur_player].getCattle() < 2
					&& players[cur_player].getFood() > 4) {
				players[cur_player].addCattle(1);
				players[cur_player].addFood(-1);
			} else if (players[cur_player].getSheep() < 4
					&& players[cur_player].getFood() < 5) {
				players[cur_player].addSheep(1);
			} else
				players[cur_player].addBoar(1);

		}

		else if (num == 40) {// fam growth or resources
			b5_resource.setVisible(false);

			if (players[cur_player].getFamily() < players[cur_player]
					.getRooms() && turn > 5) {
				players[cur_player].addFamily();
			} else {
				players[cur_player].addStone(1);
				if (players[cur_player].getReed() <= 1)
					players[cur_player].addReed(1);
				else if (players[cur_player].getClay() <= 1)
					players[cur_player].addClay(1);
				else if (players[cur_player].getWood() <= 1)
					players[cur_player].addWood(1);
				else
					players[cur_player].addReed(1);
			}

		}

		players[cur_player].useFam();
		update(false);
	}

	public void computerHarvest(int p) {// computer harvest to get more food,
										// apologies for formatting
		int max = 0;
		if (players[p].getWood() > 0 && players[p].hasJoinery()) {
			players[p].addWood(-1);
			players[p].addFood(2);
		}
		if (players[p].hasPottery() && players[p].getClay() > 0) {
			players[p].addClay(-1);
			players[p].addFood(2);
		}

		if (players[p].hasBasket() && players[p].getReed() > 0) {
			players[p].addReed(-1);
			players[p].addFood(3);
		}

		while (players[p].getFood() < players[p].getFamily() * 2) {

			if (max > 10)
				players[p].addFood(1);
			max++;// converting 1 grain in general or 1 vegetable without a
					// fireplace/hearth is extremely innefficient so i give the
					// computer a run around their other resources first

			if (players[p].getGrain() > 0 && max > 4) {
				players[p].decGrain();
				players[p].addFood(1);
			}
			if (players[p].getVege() > 0) {
				players[p].decVege();
				if (players[p].hasHearth())
					players[p].addFood(3);

				else if (players[p].hasFireplace())
					players[p].addFood(2);

				else if (max > 4)
					players[p].addFood(1);

			}

			if (players[p].getSheep() > 0) {

				if (players[p].hasHearth() || players[p].hasFireplace()) {
					players[p].addFood(2);
					players[p].addSheep(-1);
				}

			}

			if (players[p].getBoar() > 0) {

				if (players[p].hasHearth()) {
					players[p].addBoar(-1);
					players[p].addFood(3);
				}

				else if (players[p].hasFireplace()) {
					players[p].addBoar(-1);
					players[p].addFood(2);
				}

			}

			if (players[p].getCattle() > 0) {

				if (players[p].hasHearth()) {
					players[p].addCattle(-1);
					players[p].addFood(4);
				}

				else if (players[p].hasFireplace()) {
					players[p].addCattle(-1);
					players[p].addFood(3);
				}

			}

		}

	}

	public int determineValues(int i, int p) {
		int temp = 0;

		if (i == 1) {// building rooms/stables
			if (players[p].getRooms() == players[p].getFamily())
				temp += 2;
			if (players[p].getWood() > 4 && players[p].getReed() > 1
					&& players[p].getRoomType() == 'w')
				temp += 2;
			if (players[p].getWood() > 9 && players[p].getReed() > 3
					&& players[p].getRoomType() == 'w')// 2 rooms
				temp += 2;
			if (players[p].getClay() > 4 && players[p].getReed() > 1
					&& players[p].getRoomType() == 'c')
				temp += 2;
			if (players[p].getClay() > 9 && players[p].getReed() > 3
					&& players[p].getRoomType() == 'c')// 2 rooms
				temp += 2;
			if (players[p].getStone() > 4 && players[p].getReed() > 1
					&& players[p].getRoomType() == 's')
				temp += 2;
			if (players[p].getStone() > 9 && players[p].getReed() > 3
					&& players[p].getRoomType() == 's')// 2 rooms
				temp += 2;
			if (players[p].getWood() > 6)// enough for stables
				temp++;
			if (players[p].getRoomType() == 'w')
				temp++;
			if (players[p].getReed() < 2)// not enough reed to build 1 room
				temp -= 4;

		} else if (i == 2) {// start player and food
			if (((p + 1) % num_players) + 1 == start_player + 1)
				temp = 4;
			else if (((p + 1) % num_players) + 2 == start_player + 1)
				temp = 3;
			else if (((p + 1) % num_players) + 3 == start_player + 1)
				temp = 2;
		}

		else if (i == 3) {// take grain
			temp = 3;
			temp += players[p].getField();
			temp -= players[p].getGrain();

		}

		else if (i == 4) {// plow field
			temp = 2;

			if (players[p].getField() == 0)
				temp++;
			if (players[p].getField() < 3)
				temp++;
			if (players[p].getEmpty() == 0)
				temp = 0;

		}

		else if (i == 5) {// stable and bake bread
			if (players[p].getGrain() > 0) {
				if (players[p].hasCOven())
					temp = 4;
				if (players[p].getGrain() > 1 && players[p].hasSOven())
					temp += 4;
				if (players[p].getGrain() == 1 && players[p].hasSOven()
						&& !players[p].hasCOven())
					temp += 3;
				if (players[p].hasFireplace() || players[p].hasHearth()) {
					temp += players[p].getGrain();
				}

			}

		} else if (i == 6) {// day laboror, food and 1 building resource
			temp = 1;
			if (players[p].getFood() < 5) {
				temp += 1;

			}
			if (players[p].getFood() < 3) {
				temp += 1;

			}

		}

		else if (i == 7) {// +3wood
			temp = wood;
			if (players[p].getWood() < 5)
				temp += 1;
			if (players[p].getWood() > 11)
				temp--;
			if (players[p].getWood() > 8)
				temp--;
			if (players[p].getWood() > 14)
				temp--;

			if (turn > 6)
				temp--;
			if (turn > 9)
				temp--;

		}

		else if (i == 8) {// +1clay
			temp = clay;
			if (players[p].getClay() < 5) {
				temp += 1;

			}

			if (turn > 6)
				temp++;

		}

		else if (i == 9) {// +1reed
			temp = reed;
			if (players[p].getReed() < 4) {
				temp += 1;

			}

			if (players[p].getReed() < 2) {
				temp += 1;

			}

		}

		else if (i == 10) {// +1food
			temp = food;
			if (players[p].getFood() < 4) {
				temp += 1;

			}

			if (players[p].getFood() < 2) {
				temp += 1;

			}

		}

		else if (i == 11) {// +1sheep
			temp = sheep;
			if (players[p].getRemainingSpace() >= 2) {
				temp += 1;

			}

			if (players[p].getRemainingSpace() >= 5) {
				temp += 1;

			}

			if (players[p].getSheep() < 3) {
				temp += 1;

			}

			if (players[p].getRemainingSpace() < 2)
				temp -= 2;

		}

		else if (i == 12) {// +sow and bake
			temp = players[p].getGrain() - 1;

			temp += players[p].getField() - 1;

			if (players[p].hasCOven())
				temp += 1;
			if (players[p].hasSOven())
				temp += 1;
			if (players[p].hasFireplace() || players[p].hasHearth())
				temp += 1;

		}

		else if (i == 13) {// fences

			if (players[p].getRemainingSpace() < 4)
				temp = players[p].getWood() / 2;

		}

		else if (i == 14) {// major improvement

			if (players[p].getClay() > 1)
				temp += 1;
			if (players[p].getStone() > 0)
				temp += 1;
			if (players[p].getClay() > 3)
				temp += 1;
			if (players[p].getStone() > 2)
				temp += 2;
			if (players[p].hasFireplace())
				temp += 2;

			if (!players[p].hasHearth() && !players[p].hasSOven()
					&& !players[p].hasSOven())
				temp += 2;

		}

		else if (i == 15) {// stone
			temp += stone;

			if (players[p].getStone() < 2)
				temp += 1;

		}

		else if (i == 16) {// family growth

			if (players[p].getRooms() > players[p].getFamily())
				temp += 6;

			if (players[p].getFood() < 5)
				temp -= 1;

		}

		else if (i == 17) {// renovate

			if (players[p].getRoomType() == 'w' && players[p].getReed() > 0
					&& players[p].getClay() >= players[p].getRooms())
				temp += 4;

			if (players[p].getRoomType() == 'c' && players[p].getReed() > 0
					&& players[p].getStone() >= players[p].getRooms())
				temp += 4;

			temp += players[p].getRooms() - 2;

		}

		else if (i == 18) {// boar
			temp = boar;
			if (players[p].getRemainingSpace() >= 2) {
				temp += 1;

			}

			if (players[p].getRemainingSpace() >= 5) {
				temp += 1;

			}

			if (players[p].getBoar() < 3) {
				temp += 2;

			}

			if (players[p].getRemainingSpace() < 2)
				temp -= 2;

		}

		else if (i == 19) {// vege
			temp = 3;
			temp += players[p].getField();
			temp -= players[p].getVege();

		}

		else if (i == 20) {// cattle
			temp = cattle;
			if (players[p].getRemainingSpace() >= 2) {
				temp += 1;

			}

			if (players[p].getRemainingSpace() >= 5) {
				temp += 1;

			}

			if (players[p].getCattle() < 3) {
				temp += 3;

			}

			if (players[p].getRemainingSpace() < 2)
				temp -= 2;
		}

		else if (i == 21) {// stone
			temp += stone2;

			if (players[p].getStone() < 3)
				temp += 1;

		}

		else if (i == 22) {// family growth without space
			temp += 7;

			if (players[p].getFood() < 4)
				temp -= 1;

		}

		else if (i == 23) {// plow sow
			temp += players[p].getEmpty();

			if (players[p].getGrain() == 0)
				temp -= 2;
			if (players[p].getVege() > 0)
				temp += 1;
			if (players[p].getField() <= players[p].getGrain())
				temp += 1;

		}

		else if (i == 24) {// renovate and fences
			if (players[p].getRoomType() == 'w' && players[p].getReed() > 0
					&& players[p].getClay() >= players[p].getRooms())
				temp += 4;

			if (players[p].getRoomType() == 'c' && players[p].getReed() > 0
					&& players[p].getStone() >= players[p].getRooms())
				temp += 4;

			temp += players[p].getRooms() - 2;

			if (players[p].getWood() > 3)
				temp++;

		}

		else if (i == 25) {// 3p clay
			temp = clay_3p;

			if (players[p].getClay() < 3)
				temp++;
			if (players[p].getClay() > 6)
				temp--;
			if (players[p].getClay() > 9)
				temp--;

		}

		else if (i == 26) {// 3p wood
			temp = wood2_3p;
			if (players[p].getWood() < 5)
				temp += 1;
			if (players[p].getWood() > 9)
				temp--;
			if (players[p].getWood() > 11)
				temp--;
			if (players[p].getWood() > 14)
				temp--;

			if (turn > 6)
				temp--;
			if (turn > 9)
				temp--;

		}

		else if (i == 27) {// 1 building resource
			temp = 2;

		}

		else if (i == 28) {// 3p 2 building resources
			temp = 3;

		}

		else if (i == 29) {// 4p +1wood
			temp = wood_4p;

			if (players[p].getWood() < 5)
				temp += 1;
			if (players[p].getWood() > 9)
				temp--;

			if (turn > 6)
				temp--;
			if (turn > 9)
				temp--;

		}

		else if (i == 30) {// 4p +2clay
			temp = clay2_4p;

			if (players[p].getClay() < 3) {
				temp += 1;

			}

		}

		else if (i == 31) {// 4p +2wood
			temp = wood2_4p;

			if (players[p].getWood() < 5) {
				temp += 1;

			}

			if (turn > 6)
				temp--;
			if (turn > 9)
				temp--;

		}

		else if (i == 32) {// 4p food
			temp = food_4p;

			if (players[p].getFood() < 4) {
				temp += 1;

			}

			if (players[p].getFood() < 2) {
				temp += 1;

			}

		}

		else if (i == 33) {// 4p +2 resources
			temp = 3;

		}

		else if (i == 34) {// 4p +1 reed stone and food
			temp = 4;

			if (players[p].getFood() < 2) {
				temp += 1;

			}

		}

		else if (i == 35) {// 5p +4wood
			temp = wood4_5p;

			if (players[p].getWood() > 8)
				temp--;

			if (players[p].getWood() > 10)
				temp--;
			if (players[p].getWood() > 13)
				temp--;

			if (turn > 6)
				temp--;

		}

		else if (i == 36) {// 5p +3clay
			temp = clay3_5p;

			if (players[p].getClay() < 2)
				temp += 1;

			if (players[p].getClay() > 8)
				temp--;

			if (players[p].getClay() > 10)
				temp--;

		}

		else if (i == 37) {// 5p room or food
			temp = food_5p;

			if (players[p].getFood() < 3)
				temp += 1;

			if (players[p].getWood() > 4 && players[p].getReed() > 1
					&& players[p].getRoomType() == 'w')
				temp += 1;

			if (players[p].getClay() > 4 && players[p].getReed() > 1
					&& players[p].getRoomType() == 'c')
				temp += 1;

			if (players[p].getStone() > 4 && players[p].getReed() > 1
					&& players[p].getRoomType() == 's')
				temp += 1;

		}

		else if (i == 38) {// 5p +reed stone and wood
			temp = reed_5p + 2;

			if (players[p].getReed() < 2)
				temp += 1;
			if (players[p].getReed() > 4)
				temp -= 1;
		}

		else if (i == 39) {// 5p +animals
			temp = 2;

			if (players[p].getRemainingSpace() == 0) {
				temp = 0;
			}
		}

		else if (i == 40) {// 2 diff resources or family growth
			if (players[p].getRooms() > players[p].getFamily() && turn > 4)
				temp += 5;
			else {

				temp = 3;
			}

		}

		return temp;
	}

	public void displaySpaceTypes() {
		StringBuilder everything = new StringBuilder();
		/*Object opts[] = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0-",
				          "10", "01", "02", "00", "00", "00", "00", "00", "00", "00", "0-",
				          "20", "01", "02", "00", "00", "00", "00", "00", "00", "00", "0-",
				          "30", "01", "02", "00", "00", "00", "00", "00", "00", "00", "0-",
				          "40", "01", "02", "00", "00", "00", "00", "00", "00", "00", "0-",
				          "50", "01", "02", "00", "00", "00", "00", "00", "00", "00", "0-",
				          "60", "01", "02", "00", "00", "00", "00", "00", "00", "00", "0-" };*/

		for (int r = 0; r < 7; r++) {
			for (int col = 0; col < 11; col++) {
				everything.append(farm[cur_player][r][col].getType());
			}
		}
		view.getSpaceTypes.setText(everything.toString());
		/*JOptionPane.showOptionDialog(null,
				everything.toString(), "spaceTypes", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);*/
	}
	
}