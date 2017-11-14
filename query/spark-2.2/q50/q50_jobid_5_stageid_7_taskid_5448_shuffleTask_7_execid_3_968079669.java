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
/* 016 */   private int compare_2(InternalRow a, InternalRow b) {
/* 017 */
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA2;
/* 022 */     long primitiveA2;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull5 = i.isNullAt(1);
/* 026 */       int value5 = isNull5 ? -1 : (i.getInt(1));
/* 027 */       boolean isNull4 = isNull5;
/* 028 */       long value4 = -1L;
/* 029 */       if (!isNull5) {
/* 030 */         value4 = (long) value5;
/* 031 */       }
/* 032 */       isNullA2 = isNull4;
/* 033 */       primitiveA2 = value4;
/* 034 */     }
/* 035 */     i = b;
/* 036 */     boolean isNullB2;
/* 037 */     long primitiveB2;
/* 038 */     {
/* 039 */
/* 040 */       boolean isNull5 = i.isNullAt(1);
/* 041 */       int value5 = isNull5 ? -1 : (i.getInt(1));
/* 042 */       boolean isNull4 = isNull5;
/* 043 */       long value4 = -1L;
/* 044 */       if (!isNull5) {
/* 045 */         value4 = (long) value5;
/* 046 */       }
/* 047 */       isNullB2 = isNull4;
/* 048 */       primitiveB2 = value4;
/* 049 */     }
/* 050 */     if (isNullA2 && isNullB2) {
/* 051 */       // Nothing
/* 052 */     } else if (isNullA2) {
/* 053 */       return -1;
/* 054 */     } else if (isNullB2) {
/* 055 */       return 1;
/* 056 */     } else {
/* 057 */       int comp = (primitiveA2 > primitiveB2 ? 1 : primitiveA2 < primitiveB2 ? -1 : 0);
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
/* 068 */   private int compare_1(InternalRow a, InternalRow b) {
/* 069 */
/* 070 */     InternalRow i = null;  // Holds current row being evaluated.
/* 071 */
/* 072 */     i = a;
/* 073 */     boolean isNullA1;
/* 074 */     long primitiveA1;
/* 075 */     {
/* 076 */
/* 077 */       boolean isNull3 = i.isNullAt(0);
/* 078 */       int value3 = isNull3 ? -1 : (i.getInt(0));
/* 079 */       boolean isNull2 = isNull3;
/* 080 */       long value2 = -1L;
/* 081 */       if (!isNull3) {
/* 082 */         value2 = (long) value3;
/* 083 */       }
/* 084 */       isNullA1 = isNull2;
/* 085 */       primitiveA1 = value2;
/* 086 */     }
/* 087 */     i = b;
/* 088 */     boolean isNullB1;
/* 089 */     long primitiveB1;
/* 090 */     {
/* 091 */
/* 092 */       boolean isNull3 = i.isNullAt(0);
/* 093 */       int value3 = isNull3 ? -1 : (i.getInt(0));
/* 094 */       boolean isNull2 = isNull3;
/* 095 */       long value2 = -1L;
/* 096 */       if (!isNull3) {
/* 097 */         value2 = (long) value3;
/* 098 */       }
/* 099 */       isNullB1 = isNull2;
/* 100 */       primitiveB1 = value2;
/* 101 */     }
/* 102 */     if (isNullA1 && isNullB1) {
/* 103 */       // Nothing
/* 104 */     } else if (isNullA1) {
/* 105 */       return -1;
/* 106 */     } else if (isNullB1) {
/* 107 */       return 1;
/* 108 */     } else {
/* 109 */       int comp = (primitiveA1 > primitiveB1 ? 1 : primitiveA1 < primitiveB1 ? -1 : 0);
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
/* 120 */   private int compare_0(InternalRow a, InternalRow b) {
/* 121 */
/* 122 */     InternalRow i = null;  // Holds current row being evaluated.
/* 123 */
/* 124 */     i = a;
/* 125 */     boolean isNullA;
/* 126 */     long primitiveA;
/* 127 */     {
/* 128 */
/* 129 */       boolean isNull1 = i.isNullAt(3);
/* 130 */       int value1 = isNull1 ? -1 : (i.getInt(3));
/* 131 */       boolean isNull = isNull1;
/* 132 */       long value = -1L;
/* 133 */       if (!isNull1) {
/* 134 */         value = (long) value1;
/* 135 */       }
/* 136 */       isNullA = isNull;
/* 137 */       primitiveA = value;
/* 138 */     }
/* 139 */     i = b;
/* 140 */     boolean isNullB;
/* 141 */     long primitiveB;
/* 142 */     {
/* 143 */
/* 144 */       boolean isNull1 = i.isNullAt(3);
/* 145 */       int value1 = isNull1 ? -1 : (i.getInt(3));
/* 146 */       boolean isNull = isNull1;
/* 147 */       long value = -1L;
/* 148 */       if (!isNull1) {
/* 149 */         value = (long) value1;
/* 150 */       }
/* 151 */       isNullB = isNull;
/* 152 */       primitiveB = value;
/* 153 */     }
/* 154 */     if (isNullA && isNullB) {
/* 155 */       // Nothing
/* 156 */     } else if (isNullA) {
/* 157 */       return -1;
/* 158 */     } else if (isNullB) {
/* 159 */       return 1;
/* 160 */     } else {
/* 161 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 162 */       if (comp != 0) {
/* 163 */         return comp;
/* 164 */       }
/* 165 */     }
/* 166 */
/* 167 */     return 0;
/* 168 */
/* 169 */   }
/* 170 */
/* 171 */
/* 172 */   public int compare(InternalRow a, InternalRow b) {
/* 173 */
/* 174 */     InternalRow i = null;
/* 175 */
/* 176 */     int comp = compare_0(a, b);
/* 177 */     if (comp != 0) {
/* 178 */       return comp;
/* 179 */     }
/* 180 */
/* 181 */     int comp1 = compare_1(a, b);
/* 182 */     if (comp1 != 0) {
/* 183 */       return comp1;
/* 184 */     }
/* 185 */
/* 186 */     int comp2 = compare_2(a, b);
/* 187 */     if (comp2 != 0) {
/* 188 */       return comp2;
/* 189 */     }
/* 190 */
/* 191 */
/* 192 */     return 0;
/* 193 */   }
/* 194 */ }
