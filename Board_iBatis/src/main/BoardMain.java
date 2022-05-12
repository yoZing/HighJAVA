package main;

import java.util.List;
import java.util.Scanner;

import service.BoardService;
import service.IBoardService;
import vo.BoardVO;

public class BoardMain {
	public static void main(String[] args) {
		BoardMain board = new BoardMain();
		board.getStart();
	}

	private Scanner scan; // 사용자의 입력값을 받는 변수
	private IBoardService boardService;

	public BoardMain() {
		scan = new Scanner(System.in);
		boardService = new BoardService();

	}

	// 게시판 기능을 활성화 하고 메뉴를 호출 메서드
	public void getStart() {
		System.out.println("-----------------------------------");
		System.out.println("         게시판을 활성화 합니다.         ");
		System.out.println("-----------------------------------");

		menu();
	}

	public void displayMenu() {
		System.out.println("-----------------------------------");
		System.out.println("    1. 전체 목록 출력");
		System.out.println("    2. 새 글 작성");
		System.out.println("    3. 수정");
		System.out.println("    4. 삭제");
		System.out.println("    5. 검색");
		System.out.println("    6. 작업 종료");
		System.out.println("-----------------------------------");
	}

	public void menu() {
		int menu;
		do {
			displayMenu();
			System.out.print("원하는 메뉴를 선택하세요 >> ");
			menu = Integer.parseInt(scan.next());

			switch (menu) {
			case 1:
				printAll();
				break;
			case 2:
				newPost();
				break;
			case 3:
				modify();
				break;
			case 4:
				delete();
				break;
			case 5:
				search();
				break;
			case 6:
				System.out.println("-----------------------------------");
				System.out.println("          시스템을 종료합니다.          ");
				System.out.println("-----------------------------------");
				break;
			default:
				System.out.println("정확한 값을 입력해주세요.");
				break;
			}
		} while (menu != 6);
	}

	/**
	 * 검색할 게시글 번호, 제목, 글쓴이, 내용 등을 입력하면 입력한 정보만 사용하여
	 * 검색하는 기능을 구현하시오
	 * 내용은 입력한 값이 포함만 되어도 검색되도록 한다.
	 * 입력을 하지 않을 자료는 엔터키로 다음 입력으로 넘긴다.
	 */ 
	private void search() {
		scan.nextLine(); //입력 버퍼 비우기
		System.out.println("검색할 정보를 입력하세요.");
		System.out.print("게시글 번호 >> ");
		String boardNo = scan.nextLine().trim();
		
		System.out.print("제목 >> ");
		String boardTitle = scan.nextLine().trim();
		
		System.out.print("글쓴이 >> ");
		String boardWriter = scan.nextLine().trim();
		
		System.out.print("작성날짜 >> ");
		String boardDate = scan.nextLine().trim();
		
		System.out.print("내용 >> ");
		String boardContent = scan.nextLine().trim();
		
		BoardVO bv = new BoardVO();
		bv.setBoardNo(boardNo);
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardDate(boardDate);
		bv.setBoardContent(boardContent);
		
		List<BoardVO> boardList = boardService.search(bv);
		
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println(" 번호 \t 제목 \t 글쓴이 \t 작성일자 \t 내용");
		System.out.println("-----------------------------------");
		
		if(boardList.size() == 0) {
			System.out.println("검색된 게시글 정보가 없습니다.");
		} else {
			for (BoardVO bv2 : boardList) {
				System.out.println(bv2.getBoardNo() + "\t" + bv.getBoardTitle() +"\t" + bv2.getBoardWriter()
				+ "\t" + bv2.getBoardDate() + "\t" + bv.getBoardContent());
			}
		}
	}

	private void delete() {
		System.out.println();
		System.out.println("삭제할 게시물 번호를 입력하세요.");
		System.out.print("게시글 번호 >> ");

		String boardNo = scan.next();

		int cnt = boardService.delete(boardNo);

		if (cnt > 0) {
			System.out.println("게시글 삭제 성공!");
		} else {
			System.out.println("게시글 삭제 실패...!");
		}
	}

	/**
	 * 게시글 정보를 수정하기 위한 메서드
	 */
	private void modify() {
		System.out.println();
		System.out.println("수정할 게시물 번호를 입력하세요.");
		System.out.print("게시글 번호 >> ");
		String boardNo = scan.next();

		System.out.println();
		System.out.println("수정할 내용을 입력하세요.");
		System.out.print("제목 >>");
		String boardTitle = scan.next();

		System.out.print("글쓴이 >>");
		String boardWriter = scan.next();

		System.out.print("내용 >>");
		String boardContent = scan.next();

		BoardVO bv = new BoardVO();

		bv.setBoardNo(boardNo);
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardContent(boardContent);

		int cnt = boardService.modify(bv);

		if (cnt > 0) {
			System.out.println("게시글 수정 성공!");
		} else {
			System.out.println("게시글 수정 실패...!");
		}

	}

	/**
	 * 게시글 정보를 등록하기 위한 메서드
	 */
	private void newPost() {
		System.out.println();
		System.out.println("작성할 게시글 정보를 입력하세요.");

		System.out.print("제목 >> ");
		String boardTitle = scan.next();

		System.out.print("글쓴이 >> ");
		String boardWriter = scan.next();

		System.out.print("내용 >> ");
		String boardContent = scan.next();

		BoardVO bv = new BoardVO();
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardContent(boardContent);

		int cnt = boardService.newPost(bv); // 새 게시글 등록

		if (cnt > 0) {
			System.out.println("게시글 작성 성공!");
		} else {
			System.out.println("게시글 작성 실패...!");
		}
	}

	/**
	 * 전체 회원 정보를 출력하는 메서드
	 */
	private void printAll() {
		System.out.println("-----------------------------------");
		System.out.println(" 번호 \t 제목 \t 글쓴이 \t 작성일자 \t 내용");
		System.out.println("-----------------------------------");

		List<BoardVO> boardList = boardService.printAll();

		if (boardList.size() == 0) {
			System.out.println("출력할 게시글이 없습니다.");
		} else {
			for (BoardVO bv : boardList) {
				System.out.println(bv.getBoardNo() + "\t" + bv.getBoardTitle() + "\t" + bv.getBoardWriter() + "\t"
						+ bv.getBoardDate() + "\t" + bv.getBoardContent());
			}
		}
		System.out.println("-----------------------------------");
		System.out.println("출력 작업 끝...!");
	}

}