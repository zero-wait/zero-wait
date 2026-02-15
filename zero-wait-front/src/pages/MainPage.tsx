/** @jsxImportSource @emotion/react */
import { useEffect, useState } from "react";
import { type Restaurant, getList } from "../apis/restaurant";
import { styles as S } from "./mainPageStyle";

const CATEGORY_MAP: Record<number, string> = {
    1: "한식",
    2: "중식",
    3: "일식",
    4: "양식",
    5: "카페",
    6: "기타",
};

const CATEGORIES = [
    { label: "전체", value: undefined },
    { label: "한식", value: 1 },
    { label: "중식", value: 2 },
    { label: "일식", value: 3 },
    { label: "양식", value: 4 },
    { label: "카페", value: 5 },
    { label: "기타", value: 6 },
];

function MainPage() {
    const [restaurants, setRestaurants] = useState<Restaurant[]>([]);
    const [selectedCategory, setSelectedCategory] = useState<number | undefined>(undefined);
    const [isOpenOnly, setIsOpenOnly] = useState(false);
    const [hero, setHero] = useState<Restaurant | null>(null);

    const fetchRestaurants = async (categoryId?: number, isOpen?: boolean) => {
        try {
            const resp = await getList(categoryId, isOpen || undefined);
            setRestaurants(resp.data);
            if (resp.data.length > 0) setHero(resp.data[0]);
        } catch (error) {
            console.error("데이터를 가져오는데 실패했습니다.", error);
        }
    };

    useEffect(() => {
        fetchRestaurants(selectedCategory, isOpenOnly);
    }, [selectedCategory, isOpenOnly]);

    return (
        <div css={S.container}>

            {/* 헤더 */}
            <header css={S.header}>
                <div css={S.logo}>
                    ⏱ Zero-<span className="accent">Wait</span>
                </div>
                <div css={S.headerRight}>
                    <button>🏠</button>
                    <button>👤 내 계정</button>
                    <span css={S.roleBadge}>일반 사용자</span>
                </div>
            </header>

            {/* 히어로 배너 */}
            {hero && (
                <div css={S.heroBanner}>
                    <img src={hero.imageUrl} alt={hero.name} />
                    <div css={S.heroContent}>
                        <span css={S.heroCategoryBadge}>
                            {CATEGORY_MAP[hero.categoryId] ?? "기타"}
                        </span>
                        <h2 css={S.heroTitle}>{hero.name}</h2>
                        <div css={S.heroMeta}>
                            <span>⭐ {hero.ratingAvg}</span>
                            <span className="dot">•</span>
                            <span>⏱ 대기 약 {hero.estimatedWaitingTime}분</span>
                            <span className="dot">•</span>
                            <span>📍 {hero.address}</span>
                        </div>
                        <button css={S.heroBtn}>바로 웨이팅</button>
                    </div>
                </div>
            )}

            {/* 필터 탭 */}
            <div css={S.filterSection}>
                {/* 영업중 토글 */}
                <button
                    css={S.filterTab(isOpenOnly)}
                    onClick={() => setIsOpenOnly(prev => !prev)}
                >
                    영업중
                </button>

                {/* 카테고리 필터 */}
                {CATEGORIES.map(c => (
                    <button
                        key={c.label}
                        css={S.filterTab(selectedCategory === c.value)}
                        onClick={() => setSelectedCategory(c.value)}
                    >
                        {c.label}
                    </button>
                ))}
            </div>

            {/* 식당 리스트 */}
            <section css={S.listSection}>
                <div css={S.listHeader}>
                    <h3 css={S.listTitle}>
                        맛집 리스트
                        <span>{restaurants.length}개</span>
                    </h3>
                </div>

                <div css={S.restaurantList}>
                    {restaurants.map((item) => (
                        <div key={item.restaurantId} css={S.card}>
                            <div css={S.cardImageWrap}>
                                <img src={item.imageUrl} alt={item.name} />
                                <span css={S.categoryBadge}>
                                    {CATEGORY_MAP[item.categoryId] ?? "기타"}
                                </span>
                                <span css={S.waitingBadge(item.waitingCount > 0)}>
                                    {item.waitingCount > 0 ? "웨이팅 중" : "바로 입장"}
                                </span>
                            </div>

                            <div css={S.cardBody}>
                                <h4 css={S.cardName}>{item.name}</h4>
                                <p css={S.cardAddress}>📍 {item.address}</p>

                                <div css={S.cardMeta}>
                                    <span className="rating">
                                        <span className="star">★</span>
                                        {item.ratingAvg}
                                    </span>
                                    <span className="divider">|</span>
                                    <span>📞 {item.tel}</span>
                                </div>

                                <div css={S.waitingInfo}>
                                    <div css={S.waitingChip}>
                                        <div className="label">대기 인원</div>
                                        <div className="value">
                                            {item.waitingCount}<span>팀</span>
                                        </div>
                                    </div>
                                    <div css={S.waitingChip}>
                                        <div className="label">예상 대기</div>
                                        <div className="value">
                                            {item.estimatedWaitingTime}<span>분</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
            </section>
        </div>
    );
}

export default MainPage;