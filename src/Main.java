import java.io.*;

public class Main {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in;

        // StringBuilder vs "" + "" vs br.write("")
        // 장단점이 뭐지?

        // new Parser vs p.init("");
        // init이 맞겠지 이건. function init 만들고 Parser(){init()}

        // logs exit 후에도 이게 뜨게? stack이 아니라 병렬 메뉴에 가깝게 만들어야 하나.
        try {
            bw.write("Enter expression. (example: 51 * 21 + 1/5^8)\n");
            bw.write("available operator : + - / * ^\n");
            bw.write("other : exit, help, logs\n\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                in = br.readLine();
                if (in.equals("exit") || in.equals("quit")) {
                    br.close();
                    bw.close();
                    return;
                }

                if (in.equals("help")){
                    bw.write("\nhelp\n");
                    bw.write("=====\n");
                    bw.write("available operator : + - / * ^\n");
                    bw.write("현재 피연산자가 두 개인 경우만 되는 중. Parser 개선 필요.\n");
                    bw.flush();
                    continue;
                }

                if (in.equals("logs")){
                    bw.write("\nlogs\n");
                    bw.write("=====\n");
                    // remove n 추가. remove -> n 하는게 구현은 편한데, 음, 편의성?
                    // 저장은 cmd면 필요 없긴 하지? 알아서 출력 설정 되나?
                    // 아닌가. 시작할 때 해야 하니 하나 만드는게 낫나. save load? reg? locallow?
                    // 계산하다 날아가면 꼴받잖아.
                    // show 범위 지정 옵션
                    // 대소문자 미구분? Uppercase
                    bw.write("command: show, remove, clear, exit\n");
                    while(true){

                        bw.flush();

                        in = br.readLine();

                        if(in.equals("exit") || in.equals("quit")) break;

                        if(in.equals("show")) {
                            bw.write(Logger.getAll());
                            bw.flush();
                        }

                        if(in.equals("remove")){
                            Logger.remove();
                        }

                        if(in.equals("clear")){
                            Logger.clear();
                        }

                    }
                    continue;
                }

                if(in.equals("")) continue;

                Parser p  = new Parser(in);
                Logger.add("" + Calculator.postfix(p.postfix()));
                bw.write(Logger.getLast());
                bw.write("\n");
                bw.flush();



            } catch (IOException e) {
                e.printStackTrace();
            } catch (ArithmeticException e){
                System.out.println(e.getMessage());
            }
        }



    }


}

