package hunojung.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P01918 {
    static String test_case = "1: A*B*C*D\n" +
            "answer: AB*C*D*\n" +
            "#2: A\n" +
            "answer: A\n" +
            "#3: A-B/C+D/E\n" +
            "answer: ABC/-DE/+\n" +
            "#4: A*B*C+D*E+F+G/H*I+J/K+L*M-N+O*P-Q*R+S+T-U/V*W\n" +
            "answer: AB*C*DE*+F+GH/I*+JK/+LM*+N-OP*+QR*-S+T+UV/W*-\n" +
            "#5: A/B/C+D/E/F\n" +
            "answer: AB/C/DE/F/+\n" +
            "#6: A-B+C+D-E+F+G/H*I+J-K/L/M*N/O+P*Q*R-S\n" +
            "answer: AB-C+D+E-F+GH/I*+J+KL/M/N*O/-PQ*R*+S-\n" +
            "#7: A-B\n" +
            "answer: AB-\n" +
            "#8: A+B+C+D*E+F\n" +
            "answer: AB+C+DE*+F+\n" +
            "#9: A/B-C*D/E-F-G/H+I*J*K*L-M/N+O/P-Q+R+S+T/U-V-W\n" +
            "answer: AB/CD*E/-F-GH/-IJ*K*L*+MN/-OP/+Q-R+S+TU/+V-W-\n" +
            "#10: A*B+C/D-E/F*G-H+I*J+K+L+M+N+O/P*Q-R+S/T-U-V*W*X/Y*Z\n" +
            "answer: AB*CD/+EF/G*-H-IJ*+K+L+M+N+OP/Q*+R-ST/+U-VW*X*Y/Z*-\n" +
            "#11: A+B*C/D+E/F-G*H/I+J*K+L-M-N/O+P+Q*R-S/T/U/V-W+X-Y\n" +
            "answer: ABC*D/+EF/+GH*I/-JK*+L+M-NO/-P+QR*+ST/U/V/-W-X+Y-\n" +
            "#12: A*B-C-D-E-F+G/H/I*J+K/L/M*N-O\n" +
            "answer: AB*C-D-E-F-GH/I/J*+KL/M/N*+O-\n" +
            "#13: A*B-C+D/E*F+G+H/I-J-K-L+M+N*O/P\n" +
            "answer: AB*C-DE/F*+G+HI/+J-K-L-M+NO*P/+\n" +
            "#14: A/B-C/D-E\n" +
            "answer: AB/CD/-E-\n" +
            "#15: A-B*C/D+E*F-G*H-I*J+K+L*M+N-O-P+Q+R-S\n" +
            "answer: ABC*D/-EF*+GH*-IJ*-K+LM*+N+O-P-Q+R+S-\n" +
            "#16: A*B/C-D+E-F*G/H/I*J*K-L+M*N-O/P*Q/R*S+T/U-V\n" +
            "answer: AB*C/D-E+FG*H/I/J*K*-L-MN*+OP/Q*R/S*-TU/+V-\n" +
            "#17: A-B-C/D/E+F+G/H+I*J+K/L/M-N*O/P/Q/R-S+T*U/V+W-X/Y\n" +
            "answer: AB-CD/E/-F+GH/+IJ*+KL/M/+NO*P/Q/R/-S-TU*V/+W+XY/-\n" +
            "#18: A-B/C*D-E*F\n" +
            "answer: ABC/D*-EF*-\n" +
            "#19: A/B*C+D*E/F+G-H+I*J+K+L-M+N/O*P*Q*R\n" +
            "answer: AB/C*DE*F/+G+H-IJ*+K+L+M-NO/P*Q*R*+\n" +
            "#20: A+B-C*D*E/F-G*H/I*J\n" +
            "answer: AB+CD*E*F/-GH*I/J*-\n" +
            "#21: A+B-C+D/E*F\n" +
            "answer: AB+C-DE/F*+\n" +
            "#22: A*B*C-D+E/F*G+H-I-J/K/L-M/N\n" +
            "answer: AB*C*D-EF/G*+H+I-JK/L/-MN/-\n" +
            "#23: A/B-C\n" +
            "answer: AB/C-\n" +
            "#24: A+B-C-D+E+F/G+H/I+J+K+L*M+N*O*P\n" +
            "answer: AB+C-D-E+FG/+HI/+J+K+LM*+NO*P*+\n" +
            "#25: A-B*C*D*E/F-G*H/I*J*K*L+M-N*O*P*Q/R-S+T/U\n" +
            "answer: ABC*D*E*F/-GH*I/J*K*L*-M+NO*P*Q*R/-S-TU/+\n" +
            "#26: A-B+C/D-E/F/G*H+I/J+K*L/M-N/O*P*Q*R/S-T-U\n" +
            "answer: AB-CD/+EF/G/H*-IJ/+KL*M/+NO/P*Q*R*S/-T-U-\n" +
            "#27: A+B-C+D+E-F/G/H-I+J-K+L/M*N+O+P-Q*R/S\n" +
            "answer: AB+C-D+E+FG/H/-I-J+K-LM/N*+O+P+QR*S/-\n" +
            "#28: A*B-C+D\n" +
            "answer: AB*C-D+\n" +
            "#29: A*B+C+D+E/F-G+H-I/J*K*L-M+N\n" +
            "answer: AB*C+D+EF/+G-H+IJ/K*L*-M-N+\n" +
            "#30: A-B+C+D+E*F*G+H*I*J-K+L/M/N*O+P/Q+R\n" +
            "answer: AB-C+D+EF*G*+HI*J*+K-LM/N/O*+PQ/+R+\n" +
            "#31: A/B*C+D-E+F+G*H*I/J+K-L+M/N\n" +
            "answer: AB/C*D+E-F+GH*I*J/+K+L-MN/+\n" +
            "#32: A*B*C-D*E*F+G\n" +
            "answer: AB*C*DE*F*-G+\n" +
            "#33: A/B-C-D*E-F*G-H-I+J+K-L*M/N+O-P\n" +
            "answer: AB/C-DE*-FG*-H-I-J+K+LM*N/-O+P-\n" +
            "#34: A*B-C*D*E+F*G*H*I*J*K/L*M*N-O\n" +
            "answer: AB*CD*E*-FG*H*I*J*K*L/M*N*+O-\n" +
            "#35: A+B*C/D+E-F-G/H-I-J-K\n" +
            "answer: ABC*D/+E+F-GH/-I-J-K-\n" +
            "#36: A/B/C+D+E-F/G-H*I*J/K-L+M-N-O/P+Q*R/S-T\n" +
            "answer: AB/C/D+E+FG/-HI*J*K/-L-M+N-OP/-QR*S/+T-\n" +
            "#37: A*B+C+D*E-F-G\n" +
            "answer: AB*C+DE*+F-G-\n" +
            "#38: A/B+C/D+E/F/G-H+I+J*K/L*M-N*O/P*Q*R*S*T+U-V/W+X/Y\n" +
            "answer: AB/CD/+EF/G/+H-I+JK*L/M*+NO*P/Q*R*S*T*-U+VW/-XY/+\n" +
            "#39: A/B+C*D-E*F*G/H+I-J*K-L/M-N+O-P+Q*R+S-T+U/V*W\n" +
            "answer: AB/CD*+EF*G*H/-I+JK*-LM/-N-O+P-QR*+S+T-UV/W*+\n" +
            "#40: A+B-C/D-E*F*G+H*I-J\n" +
            "answer: AB+CD/-EF*G*-HI*+J-\n" +
            "#41: A/B-C+D+E-F*G*H/I-J-K/L-M+N-O-P+Q*R+S*T*U*V-W-X/Y-Z\n" +
            "answer: AB/C-D+E+FG*H*I/-J-KL/-M-N+O-P-QR*+ST*U*V*+W-XY/-Z-\n" +
            "#42: A/B/C/D+E\n" +
            "answer: AB/C/D/E+\n" +
            "#43: A-B-C+D+E\n" +
            "answer: AB-C-D+E+\n" +
            "#44: A-B*C-D*E/F-G*H*I*J\n" +
            "answer: ABC*-DE*F/-GH*I*J*-\n" +
            "#45: A/B*C\n" +
            "answer: AB/C*\n" +
            "#46: A+B+C-D-E-F+G*H+I+J\n" +
            "answer: AB+C+D-E-F-GH*+I+J+\n" +
            "#47: A-B-C+D*E/F-G-H/I-J/K-L+M/N/O+P/Q/R-S-T/U+V-W\n" +
            "answer: AB-C-DE*F/+G-HI/-JK/-L-MN/O/+PQ/R/+S-TU/-V+W-\n" +
            "#48: A/B-C*D+E/F/G+H/I*J-K/L+M/N+O-P+Q*R/S/T+U/V*W/X\n" +
            "answer: AB/CD*-EF/G/+HI/J*+KL/-MN/+O+P-QR*S/T/+UV/W*X/+\n" +
            "#49: A-B+C+D+E-F*G*H/I+J-K\n" +
            "answer: AB-C+D+E+FG*H*I/-J+K-\n" +
            "#50: A*B/C*D+E-F/G*H/I*J*K+L+M+N-O+P\n" +
            "answer: AB*C/D*E+FG/H*I/J*K*-L+M+N+O-P+\n" +
            "#51: A*((B*C)/D-(E/F+(G*H/((I*J-(((K+L*M))))/N)))+O-P*(Q/R)+S)-T\n" +
            "answer: ABC*D/EF/GH*IJ*KLM*+-N//+-O+PQR/*-S+*T-\n" +
            "#52: A+(B+C/D)+E*F/G-(H/I)+(J-K/L-M)\n" +
            "answer: ABCD/++EF*G/+HI/-JKL/-M-+\n" +
            "#53: (A+(B+(C+D*((E-((F/((G+H+I*J*(K*L))))))))))\n" +
            "answer: ABCDEFGH+IJ*KL**+/-*+++\n" +
            "#54: (A*(B-C/D))-E-F-((((G+(H*I)))-((J*(K*(L-M*N/O)-P/Q*R)/(S-T*U*V-W-X*Y/Z)))))\n" +
            "answer: ABCD/-*E-F-GHI*+JKLMN*O/-*PQ/R*-*STU*V*-W-XY*Z/-/--\n" +
            "#55: (A/B)-C*D-E*F+G+H*I/(((J-K*L)+M+N*O))\n" +
            "answer: AB/CD*-EF*-G+HI*JKL*-M+NO*+/+\n" +
            "#56: A+B/C\n" +
            "answer: ABC/+\n" +
            "#57: A+B+C+(D/E+(F+G)+(H/I))\n" +
            "answer: AB+C+DE/FG++HI/++\n" +
            "#58: A*((B*C+D*((E-F-(((G/((H/(I+J)*((K+L)/M+N))))))))))\n" +
            "answer: ABC*DEF-GHIJ+/KL+M/N+*/-*+*\n" +
            "#59: A-B+C/D-((E+(F-G)+H)+I/J+(K/L-M-N/O-(P/Q)+R+S-T/U))-V/((W*X))\n" +
            "answer: AB-CD/+EFG-+H+IJ/+KL/M-NO/-PQ/-R+S+TU/-+-VWX*/-\n" +
            "#60: ((A/B*C)/D*(E/F))+G/(H/I+J)*K+L*M-((((((N+O))))))\n" +
            "answer: AB/C*D/EF/*GHI/J+/K*+LM*+NO+-\n" +
            "#61: (A-B-C/((D+E*F*G*H)+I+J+K)-L)*(M-(N*(O*P)+Q-R)-S)\n" +
            "answer: AB-CDEF*G*H*+I+J+K+/-L-MNOP**Q+R--S-*\n" +
            "#62: (A*B)+C/D+E/F*(G*H*I+(J*K))-(L+M-N-O)-P/Q/((R/S))\n" +
            "answer: AB*CD/+EF/GH*I*JK*+*+LM+N-O--PQ/RS//-\n" +
            "#63: ((A/B))*C*(D+(E+F/G+H))\n" +
            "answer: AB/C*DEFG/+H++*\n" +
            "#64: A-(B*C*D)\n" +
            "answer: ABC*D*-\n" +
            "#65: (((A/B/C)/D-E))/F+(G-H+I*J-K*L)*(M*N)-O-P-(((Q+((R-S)-T))/(U/V/W)))\n" +
            "answer: AB/C/D/E-F/GH-IJ*+KL*-MN**+O-P-QRS-T-+UV/W//-\n" +
            "#66: A+((((B*C/D-E)-F-G*H*I)+(J-K*L)/M/N)+(O/((P+Q+(R+(S*(T/U)))))))\n" +
            "answer: ABC*D/E-F-GH*I*-JKL*-M/N/+OPQ+RSTU/*++/++\n" +
            "#67: A/B/C-D+(E-F-(G-H*I/J/K)+L)*M+N-O*P+(Q-R-S*T/U)\n" +
            "answer: AB/C/D-EF-GHI*J/K/--L+M*+N+OP*-QR-ST*U/-+\n" +
            "#68: A/B*C/((D/E+(F*G+((H+I*J-K)-L+M-N/O)/P+Q)*R)/S*T)\n" +
            "answer: AB/C*DE/FG*HIJ*+K-L-M+NO/-P/+Q+R*+S/T*/\n" +
            "#69: A+B-(C*D+E*(F-G*H)+I)\n" +
            "answer: AB+CD*EFGH*-*+I+-\n" +
            "#70: A/B\n" +
            "answer: AB/\n" +
            "#71: A/B/C-(D*E)/F/G-((H/I)*((J+((K+L)+M+N/O/P/(Q-R*S)-T*(U+(V+(((W+X-Y)))))))))\n" +
            "answer: AB/C/DE*F/G/-HI/JKL+M+NO/P/QRS*-/+TUVWX+Y-++*-+*-\n" +
            "#72: (A-B*(C+D))\n" +
            "answer: ABCD+*-\n" +
            "#73: (A+B/C+(D*(E-F))-G)*(H/I+J+K+L)/M+(N*O*P)*(Q*(R*S+T/U+V/W))\n" +
            "answer: ABC/+DEF-*+G-HI/J+K+L+*M/NO*P*QRS*TU/+VW/+**+\n" +
            "#74: A+B-((C-D/E/(F+G/(H*(I+(J-K)/(L/M-(N-O/P-Q+R+S)))))))\n" +
            "answer: AB+CDE/FGHIJK-LM/NOP/-Q-R+S+-/+*/+/--\n" +
            "#75: (A-B)*C-D+E-F/((G+H)/I-J)*K-((L-M-N-O/P)+Q)\n" +
            "answer: AB-C*D-E+FGH+I/J-/K*-LM-N-OP/-Q+-\n" +
            "#76: A*(B-(C+D/E/F*G)/H)/(I+J/K)+L-((M*N*O*((P*((Q*R)/S*(T+(U*(V/W/X-Y))))))))\n" +
            "answer: ABCDE/F/G*+H/-*IJK/+/L+MN*O*PQR*S/TUVW/X/Y-*+***-\n" +
            "#77: (A*B-C)*D-(E-F+G)-H/I/(J*((K+(((L*M*N+O))))))\n" +
            "answer: AB*C-D*EF-G+-HI/JKLM*N*O++*/-\n" +
            "#78: ((A/B))*C/D*E*F/(G-(H/I+J+K))\n" +
            "answer: AB/C*D/E*F*GHI/J+K+-/\n" +
            "#79: (A*B-C-D*E)-F*G*H-(I*J/K)*L/M/(N/O*P+((Q+R+S/T)))\n" +
            "answer: AB*C-DE*-FG*H*-IJ*K/L*M/NO/P*QR+ST/++/-\n" +
            "#80: A*B/C\n" +
            "answer: AB*C/\n" +
            "#81: A*(B/(C-D))+E/(F*G)-H-(I-J/K-(L-(M/N*O/P)/(Q*R*S*T+U)+V)/(W+X-Y))\n" +
            "answer: ABCD-/*EFG*/+H-IJK/-LMN/O*P/QR*S*T*U+/-V+WX+Y-/--\n" +
            "#82: A*B/(C/(D/E)/F+G-H+(I+J)/K+L/(M/N/((O-P)))*Q)*((R/S)/(T*U/V))\n" +
            "answer: AB*CDE//F/G+H-IJ+K/+LMN/OP-//Q*+/RS/TU*V//*\n" +
            "#83: (A/B+C)/((D-(((E-F*G)*H)-I-J)/K)/L*M*N)*O*P+Q-R-S-T/U/(((V+(W*X+Y-Z))))\n" +
            "answer: AB/C+DEFG*-H*I-J-K/-L/M*N*/O*P*Q+R-S-TU/VWX*Y+Z-+/-\n" +
            "#84: A-B+((C+D/E)/F/G/H-(((I/J)/K/L)))+M+N-O-P+Q*R*S-(T+U)*V*W/(X-Y)\n" +
            "answer: AB-CDE/+F/G/H/IJ/K/L/-+M+N+O-P-QR*S*+TU+V*W*XY-/-\n" +
            "#85: (A/B-C)/D+((((E/F*G+H))))\n" +
            "answer: AB/C-D/EF/G*H++\n" +
            "#86: (A+B+((C-D+E)+(F-G)))/(H-I/J)+K\n" +
            "answer: AB+CD-E+FG-++HIJ/-/K+\n" +
            "#87: A/B+C/D+(E*(F-G))\n" +
            "answer: AB/CD/+EFG-*+\n" +
            "#88: (A/B-C)+(D*E-F*((G*H))/I-((J+K+(L/(M/(N+(((O*P*Q)/R+S/T)/U-(V+W))))))))\n" +
            "answer: AB/C-DE*FGH**I/-JK+LMNOP*Q*R/ST/+U/VW+-+//+-+\n" +
            "#89: A/B*C/D\n" +
            "answer: AB/C*D/\n" +
            "#90: (A*B)-C-D-(E-F+G)+H*I-J+(K*L)-M/N/O-P-Q\n" +
            "answer: AB*C-D-EF-G+-HI*+J-KL*+MN/O/-P-Q-\n" +
            "#91: A/B/C+D+E/F-G*H+I*J-K*(L/M)/(((((((N+O)-P/(Q/R/S))/(((T*(U-V+W)))))))))\n" +
            "answer: AB/C/D+EF/+GH*-IJ*+KLM/*NO+PQR/S//-TUV-W+*//-\n" +
            "#92: ((A-(B*C+D*E*((F-(G*((H/(I+J-K+L-M)*(N+(((O+P)-Q)+R))))))))))\n" +
            "answer: ABC*DE*FGHIJ+K-L+M-/NOP+Q-R++**-*+-\n" +
            "#93: A+(((B/C))/(D*E))*(F+G/H)-I*J-K-L/M-N-O*P/Q*(R-S)-T/U\n" +
            "answer: ABC/DE*/FGH/+*+IJ*-K-LM/-N-OP*Q/RS-*-TU/-\n" +
            "#94: A/(((B*((C-D/E)*(F-G+H)*I/(J+(K/L/M))-(N/O+P+Q)))))\n" +
            "answer: ABCDE/-FG-H+*I*JKL/M/+/NO/P+Q+-*/\n" +
            "#95: A-B*C+D*E*((F+G))-(H/I)/J\n" +
            "answer: ABC*-DE*FG+*+HI/J/-\n" +
            "#96: (((A/((B/C)/D-E)*F*G-(H+I/J-K-L))-M))\n" +
            "answer: ABC/D/E-/F*G*HIJ/+K-L--M-\n" +
            "#97: A*B-C+(D-(E*F*(G-H+I+J-((K*L/M-(N/O+(P*Q-R/(S*T))))))))\n" +
            "answer: AB*C-DEF*GH-I+J+KL*M/NO/PQ*RST*/-+--*-+\n" +
            "#98: (A*(B*C-D+E-(((F-G)+H/((I*(J-K))))+(L*M*N*(O/P*(Q*R))*S+T)-U*(V/W-X))))\n" +
            "answer: ABC*D-E+FG-HIJK-*/+LM*N*OP/QR***S*T++UVW/X-*--*\n" +
            "#99: A/B*C-D/(E-((F+(G-(H+I*J)))))\n" +
            "answer: AB/C*DEFGHIJ*+-+-/-\n" +
            "#100: A/(B-C)/(D*(E-F)*G)*H\n" +
            "answer: ABC-/DEF-*G*/H*";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String expression = br.readLine();

        Stack<Character> stack = new Stack<>();
        set_expression(stack, expression, 0);
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());

        // 테스트
//        int T = 100;
//        StringTokenizer st = new StringTokenizer(test_case);
//        while(T-->0) {
//            StringBuilder sb2 = new StringBuilder();
//            st.nextToken();
//            String expression_test = st.nextToken();
//
//            Stack<Character> stack2 = new Stack<>();
//            set_expression(stack2, expression_test, 0);
//            while (!stack2.isEmpty()) {
//                sb2.append(stack2.pop());
//            }
//
//            st.nextToken();
//            String answer_test = st.nextToken();
//
//            System.out.println(answer_test);
//            System.out.println(sb2.reverse());
//        }
//
        br.close();
        System.exit(0);
    }

    static int set_expression(Stack<Character> stack, String expression,int start){
        char plus_minus_save = ' ';
        for(int i = start; i<expression.length();i++){
            char c = expression.charAt(i);

            if(c>='A' && c<='Z') {
                stack.push(c);
            }else if(c == '('){
                int next_idx = set_expression(stack,expression,i+1);
                i = next_idx;
            }else if(c == ')'){
                if(plus_minus_save!=' ') stack.push(plus_minus_save);
                return i;
            }else{

                // 연산자 중 *, /
                if(c=='*' || c=='/'){
                    // * 뒤에 괄호나오면 뒤에 처리하고 * 넣기
                    if(expression.charAt(i+1) == '(') {
                        int next_idx = set_expression(stack, expression, i + 2);
                        i = next_idx;
                        stack.push(c);

                    // * 뒤에 알파벳이면 바로 처리
                    }else{
                        stack.push(expression.charAt(++i));
                        stack.push(c);
                    }
                // 연산자 중 +, -
                }else{
                    if(plus_minus_save == ' ') {
                        plus_minus_save = c;
                    }else{
                        stack.push(plus_minus_save);
                        plus_minus_save = c;
                    }
                }
            }
        }
        if(plus_minus_save!=' ') stack.push(plus_minus_save);
        return expression.length();
    }
}
