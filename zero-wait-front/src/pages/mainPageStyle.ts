/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';

const NAVY = '#1a2744';
const YELLOW = '#f5c518';
const YELLOW_DARK = '#d4a800';
const BG = '#f5f6fa';
const WHITE = '#ffffff';
const GRAY1 = '#f0f1f5';
const GRAY2 = '#e0e1e6';
const GRAY3 = '#999aaa';
const GRAY4 = '#555666';
const TEXT = '#1a1b2e';

export const styles = {

  container: css`
    min-height: 100vh;
    background: ${BG};
    font-family: 'Pretendard', 'Apple SD Gothic Neo', sans-serif;
    color: ${TEXT};
  `,

  /* ── 헤더 ── */
  header: css`
    background: ${NAVY};
    padding: 0 20px;
    height: 56px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    position: sticky;
    top: 0;
    z-index: 100;
  `,

  logo: css`
    display: flex;
    align-items: center;
    gap: 8px;
    color: ${WHITE};
    font-size: 18px;
    font-weight: 700;
    letter-spacing: -0.3px;

    .accent { color: ${YELLOW}; }
  `,

  headerRight: css`
    display: flex;
    align-items: center;
    gap: 12px;

    button {
      background: none;
      border: none;
      color: ${WHITE};
      font-size: 13px;
      cursor: pointer;
      padding: 6px 10px;
      border-radius: 6px;
      transition: background 0.15s;
      &:hover { background: rgba(255,255,255,0.1); }
    }
  `,

  roleBadge: css`
    background: rgba(245, 197, 24, 0.2);
    color: ${YELLOW};
    font-size: 12px;
    font-weight: 600;
    padding: 4px 10px;
    border-radius: 20px;
    border: 1px solid rgba(245, 197, 24, 0.4);
  `,

  /* ── 히어로 배너 ── */
  heroBanner: css`
    position: relative;
    height: 300px;
    overflow: hidden;

    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
      display: block;
    }

    &::after {
      content: '';
      position: absolute;
      inset: 0;
      background: linear-gradient(
        to right,
        rgba(10, 15, 40, 0.82) 0%,
        rgba(10, 15, 40, 0.4) 60%,
        transparent 100%
      );
    }
  `,

  heroContent: css`
    position: absolute;
    bottom: 36px;
    left: 32px;
    z-index: 2;
    color: ${WHITE};
  `,

  heroCategoryBadge: css`
    display: inline-block;
    background: ${YELLOW};
    color: ${NAVY};
    font-size: 11px;
    font-weight: 700;
    padding: 3px 10px;
    border-radius: 4px;
    margin-bottom: 10px;
    letter-spacing: 0.3px;
  `,

  heroTitle: css`
    font-size: 28px;
    font-weight: 800;
    margin: 0 0 8px 0;
    letter-spacing: -0.5px;
    line-height: 1.2;
  `,

  heroMeta: css`
    display: flex;
    align-items: center;
    gap: 12px;
    font-size: 13px;
    color: rgba(255,255,255,0.85);
    margin-bottom: 16px;

    .dot { color: rgba(255,255,255,0.4); }
  `,

  heroBtn: css`
    background: ${YELLOW};
    color: ${NAVY};
    border: none;
    font-size: 14px;
    font-weight: 700;
    padding: 10px 20px;
    border-radius: 8px;
    cursor: pointer;
    transition: background 0.15s, transform 0.1s;

    &:hover {
      background: ${YELLOW_DARK};
      transform: translateY(-1px);
    }
  `,

  /* ── 필터 탭 (영업중 토글 + 카테고리) ── */
  filterSection: css`
    padding: 14px 20px 0;
    display: flex;
    gap: 8px;
    overflow-x: auto;
    scrollbar-width: none;
    &::-webkit-scrollbar { display: none; }
  `,

  filterTab: (active: boolean) => css`
    flex-shrink: 0;
    height: 34px;
    padding: 0 14px;
    border-radius: 20px;
    font-size: 13px;
    font-weight: ${active ? 700 : 500};
    cursor: pointer;
    transition: all 0.15s;
    border: 1.5px solid ${active ? NAVY : GRAY2};
    background: ${active ? NAVY : WHITE};
    color: ${active ? WHITE : GRAY4};

    &:hover {
      border-color: ${NAVY};
      color: ${active ? WHITE : NAVY};
    }
  `,

  /* ── 리스트 섹션 ── */
  listSection: css`
    padding: 20px 20px 40px;
  `,

  listHeader: css`
    display: flex;
    align-items: center;
    margin-bottom: 14px;
  `,

  listTitle: css`
    font-size: 17px;
    font-weight: 700;
    color: ${TEXT};
    margin: 0;

    span {
      font-size: 14px;
      font-weight: 500;
      color: ${GRAY3};
      margin-left: 6px;
    }
  `,

  restaurantList: css`
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
    gap: 16px;
  `,

  /* ── 카드 ── */
  card: css`
    background: ${WHITE};
    border-radius: 14px;
    overflow: hidden;
    border: 1px solid ${GRAY1};
    box-shadow: 0 2px 8px rgba(0,0,0,0.06);
    cursor: pointer;
    transition: transform 0.18s, box-shadow 0.18s;

    &:hover {
      transform: translateY(-4px);
      box-shadow: 0 8px 24px rgba(0,0,0,0.12);
    }
  `,

  cardImageWrap: css`
    position: relative;
    height: 160px;
    overflow: hidden;

    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
      display: block;
      transition: transform 0.3s;
    }

    &:hover img { transform: scale(1.04); }
  `,

  categoryBadge: css`
    position: absolute;
    top: 10px;
    left: 10px;
    background: ${NAVY};
    color: ${WHITE};
    font-size: 11px;
    font-weight: 600;
    padding: 3px 8px;
    border-radius: 4px;
  `,

  waitingBadge: (hasWaiting: boolean) => css`
    position: absolute;
    top: 10px;
    right: 10px;
    background: ${hasWaiting ? YELLOW : '#4caf50'};
    color: ${hasWaiting ? NAVY : WHITE};
    font-size: 11px;
    font-weight: 700;
    padding: 3px 8px;
    border-radius: 4px;
  `,

  cardBody: css`
    padding: 14px 16px 16px;
  `,

  cardName: css`
    font-size: 16px;
    font-weight: 700;
    color: ${TEXT};
    margin: 0 0 6px 0;
    letter-spacing: -0.2px;
  `,

  cardAddress: css`
    font-size: 12px;
    color: ${GRAY3};
    margin: 0 0 10px 0;
  `,

  cardMeta: css`
    display: flex;
    align-items: center;
    gap: 10px;
    font-size: 13px;
    color: ${GRAY4};
    margin-bottom: 12px;

    .rating {
      display: flex;
      align-items: center;
      gap: 3px;
      font-weight: 600;
      color: ${TEXT};
    }

    .star { color: ${YELLOW}; }
    .divider { color: ${GRAY2}; }
  `,

  waitingInfo: css`
    display: flex;
    gap: 8px;
    padding-top: 10px;
    border-top: 1px solid ${GRAY1};
  `,

  waitingChip: css`
    flex: 1;
    background: ${GRAY1};
    border-radius: 8px;
    padding: 7px 10px;
    text-align: center;

    .label {
      font-size: 11px;
      color: ${GRAY3};
      margin-bottom: 2px;
    }

    .value {
      font-size: 14px;
      font-weight: 700;
      color: ${TEXT};

      span {
        font-size: 11px;
        font-weight: 500;
        color: ${GRAY4};
      }
    }
  `,
};