/* 001 */ public SpecificOrdering generate(Object[] references) {
/* 002 */   return new SpecificOrdering(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificOrdering extends org.apache.spark.sql.catalyst.expressions.codegen.BaseOrdering {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */
/* 009 */
/* 010 */   public SpecificOrdering(Object[] references) {
/* 011 */     this.references = references;
/* 012 */
/* 013 */   }
/* 014 */
/* 015 */
/* 016 */   private int compare_1(InternalRow a, InternalRow b) {
/* 017 */
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA1;
/* 022 */     long primitiveA1;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull3 = i.isNullAt(0);
/* 026 */       int value3 = isNull3 ? -1 : (i.getInt(0));
/* 027 */       boolean isNull2 = isNull3;
/* 028 */       long value2 = -1L;
/* 029 */       if (!isNull3) {
/* 030 */         value2 = (long) value3;
/* 031 */       }
/* 032 */       isNullA1 = isNull2;
/* 033 */       primitiveA1 = value2;
/* 034 */     }
/* 035 */     i = b;
/* 036 */     boolean isNullB1;
/* 037 */     long primitiveB1;
/* 038 */     {
/* 039 */
/* 040 */       boolean isNull3 = i.isNullAt(0);
/* 041 */       int value3 = isNull3 ? -1 : (i.getInt(0));
/* 042 */       boolean isNull2 = isNull3;
/* 043 */       long value2 = -1L;
/* 044 */       if (!isNull3) {
/* 045 */         value2 = (long) value3;
/* 046 */       }
/* 047 */       isNullB1 = isNull2;
/* 048 */       primitiveB1 = value2;
/* 049 */     }
/* 050 */     if (isNullA1 && isNullB1) {
/* 051 */       // Nothing
/* 052 */     } else if (isNullA1) {
/* 053 */       return -1;
/* 054 */     } else if (isNullB1) {
/* 055 */       return 1;
/* 056 */     } else {
/* 057 */       int comp = (primitiveA1 > primitiveB1 ? 1 : primitiveA1 < primitiveB1 ? -1 : 0);
/* 058 */       if (comp != 0) {
/* 059 */         return comp;
/* 060 */       }
/* 061 */     }
/* 062 */
/* 063 */     return 0;
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */
/* 068 */   private int compare_0(InternalRow a, InternalRow b) {
/* 069 */
/* 070 */     InternalRow i = null;  // Holds current row being evaluated.
/* 071 */
/* 072 */     i = a;
/* 073 */     boolean isNullA;
/* 074 */     long primitiveA;
/* 075 */     {
/* 076 */
/* 077 */       boolean isNull1 = i.isNullAt(2);
/* 078 */       int value1 = isNull1 ? -1 : (i.getInt(2));
/* 079 */       boolean isNull = isNull1;
/* 080 */       long value = -1L;
/* 081 */       if (!isNull1) {
/* 082 */         value = (long) value1;
/* 083 */       }
/* 084 */       isNullA = isNull;
/* 085 */       primitiveA = value;
/* 086 */     }
/* 087 */     i = b;
/* 088 */     boolean isNullB;
/* 089 */     long primitiveB;
/* 090 */     {
/* 091 */
/* 092 */       boolean isNull1 = i.isNullAt(2);
/* 093 */       int value1 = isNull1 ? -1 : (i.getInt(2));
/* 094 */       boolean isNull = isNull1;
/* 095 */       long value = -1L;
/* 096 */       if (!isNull1) {
/* 097 */         value = (long) value1;
/* 098 */       }
/* 099 */       isNullB = isNull;
/* 100 */       primitiveB = value;
/* 101 */     }
/* 102 */     if (isNullA && isNullB) {
/* 103 */       // Nothing
/* 104 */     } else if (isNullA) {
/* 105 */       return -1;
/* 106 */     } else if (isNullB) {
/* 107 */       return 1;
/* 108 */     } else {
/* 109 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 110 */       if (comp != 0) {
/* 111 */         return comp;
/* 112 */       }
/* 113 */     }
/* 114 */
/* 115 */     return 0;
/* 116 */
/* 117 */   }
/* 118 */
/* 119 */
/* 120 */   public int compare(InternalRow a, InternalRow b) {
/* 121 */
/* 122 */     InternalRow i = null;
/* 123 */
/* 124 */     int comp = compare_0(a, b);
/* 125 */     if (comp != 0) {
/* 126 */       return comp;
/* 127 */     }
/* 128 */
/* 129 */     int comp1 = compare_1(a, b);
/* 130 */     if (comp1 != 0) {
/* 131 */       return comp1;
/* 132 */     }
/* 133 */
/* 134 */
/* 135 */     return 0;
/* 136 */   }
/* 137 */ }
