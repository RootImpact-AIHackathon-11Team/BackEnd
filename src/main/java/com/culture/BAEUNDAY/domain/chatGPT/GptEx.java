package com.culture.BAEUNDAY.domain.chatGPT;


import org.springframework.stereotype.Component;


@Component
public class GptEx {

    private final String systemMsg =
            "너는 사용자가 입력한 강의명(주제)를 바탕으로 체계적인 강의 기획안(커리큘럼)을 상세하게 작성해주는 컨설턴트야.\n" +
                    "대상 연령대에 맞춘 말투를 사용해.\n" +
                    "사용자의 지역 특성에 맞는 강의도 몇 개 넣으면 더 센스 있겠지?" +
                    "\n" +
                    "다음과 같은 형식으로 작성해줘." +
                    "마크다운 형식으로 작성해줘. 마크다운의 #를 사용할때는 #를 한 개 더 붙여줘.\n" +
                    "1. 강의 개요 : 강의명을 참고해서 강의 개요를 생성해줘\n" +
                    "2. 강의 목표 : 구체적인 강의 목표 \n" +
                    "3. 강의 개요 : 구체적인 강의 개요\n" +
                    "4. 강의 형태 : 구체적인 강의 진행 형태 \n" +
                    "5. 강의 대상 : 구체적인 강의 대상 \n" +
                    "6. 커리큘럼 : 회차 활동과 구체적인 내용 작성\n" +
                    "7. 유의점 : 주제와 관련돼서 특별히 조심해야 하는 점 \n" +
                    "8. 홍보 자료 생성 : 강의 소개문, SNS 홍보 게시글 초안을 자동 생성\n" +
                    "\n" +
                    "커리큘럼 작성 step-by-step을 제시해줄게.\n" +
                    "1. 사용자가 너에게 포괄적인 강의 주제를 줄거야. 그 주제에 대해서 할 수 있는 다양한 활동들에 대해서 생각해봐.\n" +
                    "2. 강의 횟수에 따라서 회차별로 각각의 큰 활동들을 정리해.\n" +
                    "3. step2에서 강의 횟수가 너무 많다면 일정한 횟수만큼 묶어서 정리해도 돼. 하지만 되도록 모든 회차를 작성해.\n" +
                    "4. 회차별로 대략적인 활동 내용을 적고, 더 세부적인 활동 내용도 덧붙여.";


    private final String example1 =
            "1번 예제\n" +
            "# 1. 강의 개요\n" +
            "\n" +
            "“만화 창작 끝장내기 “는 만화를 창작하고 싶어하는 사람들을 위한 특별한 만화 클래스입니다. 자신의 상상력과 강사의 노하우를 더해 신선한 만화를 제작해보세요 !\n" +
            "\n" +
            "# 2. 강의 목표\n" +
            "\n" +
            "이 수업에서는 만화 창작에 필요한 다양한 기술과 창의력을 바탕으로 실제로 다양한 형식의 만화 작품을 창작해봄으로써 독자와 공감대를 이룰 수 있는 만화를 제작할 수 있는 능력을 기를 수 있습니다.\n" +
            "\n" +
            "# 3. 강의 대상\n" +
            "\n" +
            "- 만화에 관심 있는 분\n" +
            "- 자신의 스토리를 기록하고 싶은 분\n" +
            "- 만화 기술을 통해 수익을 창출하고자 하는 분\n" +
            "\n" +
            "# 4. 강의 운영 방식\n" +
            "\n" +
            "- 진행 형태 : 오프라인 강의\n" +
            "- 일정 : 주 1회, 1시간씩 총 7주간 진행\n" +
            "- 장소 : 부산광역시 금정구\n" +
            "- 강의료 : 50000원\n" +
            "- 준비물 : A4용지, 필기도구\n" +
            "\n" +
            "# 5. 커리큘럼\n" +
            "\n" +
            "### 1회차 :  오리엔테이션 + 만화, 웹툰에 대한 개념과 현황\n" +
            "\n" +
            "1) 목표 \n" +
            "\n" +
            "- 만화(웹툰)에 대한 일반적 개념과 현황을 이해하고 각자 창작의 방향\n" +
            "\n" +
            "2) 세부 내용 \n" +
            "\n" +
            "- 만화 및 만화 창작의 일반적인 개념과 현황\n" +
            "\n" +
            "### 2회차 : 웹툰 작품 기획안이란?\n" +
            "\n" +
            "1) 목표 \n" +
            "\n" +
            "- 작품 기획안이란 무엇이고 왜 필요한지 이해하기\n" +
            "\n" +
            "2) 세부 내용 :\n" +
            "\n" +
            "- 작품 기획안의 요소와 내용\n" +
            "- 작품 기획안 양식 및 작성법\n" +
            "\n" +
            "### 3회차 : 스토리텔링 기획(1) 아이디어 구상\n" +
            "\n" +
            "1) 목표 \n" +
            "\n" +
            "- 웹툰 스토리의 기초 개념과 구성 요소들에 대해 이해하기\n" +
            "\n" +
            "2) 세부 내용 :\n" +
            "\n" +
            "- 재미있는 웹툰 스토리의 조건\n" +
            "- 스토리의 구성 요소들 : 캐릭터, 사건, 주제\n" +
            "\n" +
            "### 4회차 : 스토리텔링 기획(2)\n" +
            "\n" +
            "1) 목표 \n" +
            "\n" +
            "- 창작 스토리를 구체화할 수 있도록 캐릭터의 세부 설정 및 세계관과\n" +
            "이야기 구조를 만드는 방법론을 확인하고 실습에 적용\n" +
            "\n" +
            "2) 세부 내용 :\n" +
            "\n" +
            "- 캐릭터의 세부 설정\n" +
            "- 세계관 설정\n" +
            "- 이야기 구조(3막 구조, 영웅의 여정 12단계 등)\n" +
            "\n" +
            "### 5회차 :\n" +
            "\n" +
            "1) 목표 \n" +
            "\n" +
            "- 작품 기획안이란 무엇이고 왜 필요한지 이해하기\n" +
            "\n" +
            "2) 세부 내용 :\n" +
            "\n" +
            "- 작품 기획안의 요소와 내용\n" +
            "- 작품 기획안 양식 및 작성법\n" +
            "\n" +
            "### 6회차 : 웹툰 제작 설계를 위한 트리트먼트\n" +
            "\n" +
            "1) 목표 \n" +
            "\n" +
            "- 웹툰의 제작 양식과 트리트먼트의 개념을 이해하고 트리트먼트 작성법\n" +
            "\n" +
            "2) 세부 내용 :\n" +
            "\n" +
            "- 웹툰의 보편적 제작 포맷과 유통 형식\n" +
            "- 트리트먼트의 개념과 작성법\n" +
            "\n" +
            "### 7회차 : 웹툰 콘티 제작\n" +
            "\n" +
            "1) 목표 \n" +
            "\n" +
            "- 그림 콘티를 제작하기 위한 기본 연출, 특히 쇼트와 앵글의 개념을 이\n" +
            "해하고 구사 방법을 습득\n" +
            "\n" +
            "2) 세부 내용 :\n" +
            "\n" +
            "- 기존 작품의 시점과 템포 구사 사례 분석\n" +
            "- 본인의 웹툰 콘티 제작해보기\n" +
            "\n" +
            "# 6. 추가 안내 사항\n" +
            "\n" +
            "- **『만화 만드는 법 ,야마모토 오사무 』**  교재를 사용할 예정입니다. 미리 준비해서 오시길 바랍니다.\n" +
            "\n" +
            "# 7. 홍보 자료\n" +
            "\n" +
            "- 만화에 관심은 있는데, 무엇부터 해야할지 모르겠다고요?  그럼 여길 주목 ⭐⭐ !!\n" +
            "”만화 창작 끝장내기” 클래스를 통해서 기초부터 콘티 제작까지, 만화가로써의 역량을 길러보세요 !";


    private final String example2 =
            "2번 예제\n" +
            "# 1. 강의 개요\n" +
            "\n" +
            "꽃... 좋아하세요?는 꽃을 사랑하는 사람들을 위한 특별한 플라워 클래스입니다. 아름다운 꽃꽂이를 배우며 꽃을 활용한 감각적인 연출법을 익히고, 자연이 주는 힐링을 경험할 수 있습니다. 꽃집 운영 경험이 있는 강사가 실전 노하우를 직접 전수하며, 초보자도 쉽게 따라 할 수 있도록 구성된 체험형 강의입니다.\n" +
            "\n" +
            "# 2. 강의 목표\n" +
            "\n" +
            "- 꽃꽂이의 기본 원리와 스타일을 익힌다\n" +
            "- 다양한 꽃과 식물을 조화롭게 활용하는 방법을 배운다\n" +
            "- 꽃을 통한 감성 힐링과 인테리어 연출법을 익힌다\n" +
            "\n" +
            "# 3. 강의 대상\n" +
            "\n" +
            "- 꽃과 플라워 디자인에 관심 있는 분\n" +
            "- 감각적인 인테리어 및 공간 연출을 하고 싶은 분\n" +
            "- 꽃을 활용한 힐링과 취미 활동을 찾는 분\n" +
            "\n" +
            "# 4. 강의 운영 방식\n" +
            "\n" +
            "- 진행 형태 : 오프라인 체험형 강의\n" +
            "- 일정 : 1회 1시간, 총 3번 진행 ( 총 3시간)\n" +
            "- 장소 : 구미시 플라워 스튜디오\n" +
            "- 강의료 : 70,000원\n" +
            "- 준비물 : 가위, 앞치마 (강의실에서 대여 가능)\n" +
            "\n" +
            "# 5. 커리큘럼\n" +
            "\n" +
            "### 1회차 : 꽃과 친해지기\n" +
            "\n" +
            "1) 목표 \n" +
            "\n" +
            "- 꽃에 대한 기본적인 지식을 익히고 특징을 익힌다\n" +
            "\n" +
            "2) 세부 내용 \n" +
            "\n" +
            "- 꽃의 종류 및 계절별 특징\n" +
            "- 꽃 손질 및 관리법, 꽃꽂이에 필요한 기본 도구 소개\n" +
            "\n" +
            "### 2회차 : 감각적인 꽃꽂이 실습\n" +
            "\n" +
            "1) 목표 \n" +
            "\n" +
            "- 기본 꽃꽂이 기법을 익힌다\n" +
            "\n" +
            "2) 세부 내용 :\n" +
            "\n" +
            "- 색감과 형태를 고려한 디자인 연출\n" +
            "- 플라워 어레인지먼트 제작\n" +
            "\n" +
            "### 3회차 : 나만의 꽃 작품 만들기\n" +
            "\n" +
            "1) 목표 \n" +
            "\n" +
            "- 직접 작품을 만들고 피드백 및 사진 촬영\n" +
            "\n" +
            "2) 세부 내용 :\n" +
            "\n" +
            "- 개성 있는 꽃다발 또는 센터피스 제작\n" +
            "- 꽃 관리법 및 디스플레이 팁 공유\n" +
            "\n" +
            "# 6. 추가 안내 사항\n" +
            "\n" +
            "- 모든 꽃과 재료는 강의실에서 제공되며, 꽃 재료 비용은 강의료에 포함됩니다.\n" +
            "- 완성된 꽃꽂이는 가져갈 수 있습니다.\n" +
            "- 강의 신청은 선착순 마감되며, 환불 및 변경 규정은 별도 안내드립니다.\n" +
            "\n" +
            "# 7. 홍보 자료\n" +
            "\n" +
            "- \uD83C\uDF38 당신은 참 예쁜 꽃,,, 당신을 닮은 꽃을 만들어보세요 !  \uD83C\uDF38\n" +
            "- 꽃과 함께 하루를 감동으로 시작해보세요. 한송이 한송이 꽃을 다루어보며 꽃향기를 느낀다면 사랑을 느낄 수 있어요.";
    public String getEx1(){
        return example1;
    }
    public String getEx2(){return example2;}
    public String getSystemMsg() {return systemMsg;}
}
