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
/* 021 */     boolean isNullA4;
/* 022 */     UTF8String primitiveA4;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull4 = i.isNullAt(4);
/* 026 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(4));
/* 027 */       isNullA4 = isNull4;
/* 028 */       primitiveA4 = value4;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB4;
/* 032 */     UTF8String primitiveB4;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull4 = i.isNullAt(4);
/* 036 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(4));
/* 037 */       isNullB4 = isNull4;
/* 038 */       primitiveB4 = value4;
/* 039 */     }
/* 040 */     if (isNullA4 && isNullB4) {
/* 041 */       // Nothing
/* 042 */     } else if (isNullA4) {
/* 043 */       return -1;
/* 044 */     } else if (isNullB4) {
/* 045 */       return 1;
/* 046 */     } else {
/* 047 */       int comp = primitiveA4.compare(primitiveB4);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */     return 0;
/* 054 */
/* 055 */   }
/* 056 */
/* 057 */
/* 058 */   private int compare_1(InternalRow a, InternalRow b) {
/* 059 */
/* 060 */     InternalRow i = null;  // Holds current row being evaluated.
/* 061 */
/* 062 */     i = a;
/* 063 */     boolean isNullA2;
/* 064 */     int primitiveA2;
/* 065 */     {
/* 066 */
/* 067 */       boolean isNull2 = i.isNullAt(2);
/* 068 */       int value2 = isNull2 ? -1 : (i.getInt(2));
/* 069 */       isNullA2 = isNull2;
/* 070 */       primitiveA2 = value2;
/* 071 */     }
/* 072 */     i = b;
/* 073 */     boolean isNullB2;
/* 074 */     int primitiveB2;
/* 075 */     {
/* 076 */
/* 077 */       boolean isNull2 = i.isNullAt(2);
/* 078 */       int value2 = isNull2 ? -1 : (i.getInt(2));
/* 079 */       isNullB2 = isNull2;
/* 080 */       primitiveB2 = value2;
/* 081 */     }
/* 082 */     if (isNullA2 && isNullB2) {
/* 083 */       // Nothing
/* 084 */     } else if (isNullA2) {
/* 085 */       return -1;
/* 086 */     } else if (isNullB2) {
/* 087 */       return 1;
/* 088 */     } else {
/* 089 */       int comp = (primitiveA2 > primitiveB2 ? 1 : primitiveA2 < primitiveB2 ? -1 : 0);
/* 090 */       if (comp != 0) {
/* 091 */         return comp;
/* 092 */       }
/* 093 */     }
/* 094 */
/* 095 */     i = a;
/* 096 */     boolean isNullA3;
/* 097 */     int primitiveA3;
/* 098 */     {
/* 099 */
/* 100 */       boolean isNull3 = i.isNullAt(3);
/* 101 */       int value3 = isNull3 ? -1 : (i.getInt(3));
/* 102 */       isNullA3 = isNull3;
/* 103 */       primitiveA3 = value3;
/* 104 */     }
/* 105 */     i = b;
/* 106 */     boolean isNullB3;
/* 107 */     int primitiveB3;
/* 108 */     {
/* 109 */
/* 110 */       boolean isNull3 = i.isNullAt(3);
/* 111 */       int value3 = isNull3 ? -1 : (i.getInt(3));
/* 112 */       isNullB3 = isNull3;
/* 113 */       primitiveB3 = value3;
/* 114 */     }
/* 115 */     if (isNullA3 && isNullB3) {
/* 116 */       // Nothing
/* 117 */     } else if (isNullA3) {
/* 118 */       return -1;
/* 119 */     } else if (isNullB3) {
/* 120 */       return 1;
/* 121 */     } else {
/* 122 */       int comp = (primitiveA3 > primitiveB3 ? 1 : primitiveA3 < primitiveB3 ? -1 : 0);
/* 123 */       if (comp != 0) {
/* 124 */         return comp;
/* 125 */       }
/* 126 */     }
/* 127 */
/* 128 */     return 0;
/* 129 */
/* 130 */   }
/* 131 */
/* 132 */
/* 133 */   private int compare_0(InternalRow a, InternalRow b) {
/* 134 */
/* 135 */     InternalRow i = null;  // Holds current row being evaluated.
/* 136 */
/* 137 */     i = a;
/* 138 */     boolean isNullA;
/* 139 */     UTF8String primitiveA;
/* 140 */     {
/* 141 */
/* 142 */       UTF8String value = i.getUTF8String(0);
/* 143 */       isNullA = false;
/* 144 */       primitiveA = value;
/* 145 */     }
/* 146 */     i = b;
/* 147 */     boolean isNullB;
/* 148 */     UTF8String primitiveB;
/* 149 */     {
/* 150 */
/* 151 */       UTF8String value = i.getUTF8String(0);
/* 152 */       isNullB = false;
/* 153 */       primitiveB = value;
/* 154 */     }
/* 155 */     if (isNullA && isNullB) {
/* 156 */       // Nothing
/* 157 */     } else if (isNullA) {
/* 158 */       return -1;
/* 159 */     } else if (isNullB) {
/* 160 */       return 1;
/* 161 */     } else {
/* 162 */       int comp = primitiveA.compare(primitiveB);
/* 163 */       if (comp != 0) {
/* 164 */         return comp;
/* 165 */       }
/* 166 */     }
/* 167 */
/* 168 */     i = a;
/* 169 */     boolean isNullA1;
/* 170 */     int primitiveA1;
/* 171 */     {
/* 172 */
/* 173 */       boolean isNull1 = i.isNullAt(1);
/* 174 */       int value1 = isNull1 ? -1 : (i.getInt(1));
/* 175 */       isNullA1 = isNull1;
/* 176 */       primitiveA1 = value1;
/* 177 */     }
/* 178 */     i = b;
/* 179 */     boolean isNullB1;
/* 180 */     int primitiveB1;
/* 181 */     {
/* 182 */
/* 183 */       boolean isNull1 = i.isNullAt(1);
/* 184 */       int value1 = isNull1 ? -1 : (i.getInt(1));
/* 185 */       isNullB1 = isNull1;
/* 186 */       primitiveB1 = value1;
/* 187 */     }
/* 188 */     if (isNullA1 && isNullB1) {
/* 189 */       // Nothing
/* 190 */     } else if (isNullA1) {
/* 191 */       return -1;
/* 192 */     } else if (isNullB1) {
/* 193 */       return 1;
/* 194 */     } else {
/* 195 */       int comp = (primitiveA1 > primitiveB1 ? 1 : primitiveA1 < primitiveB1 ? -1 : 0);
/* 196 */       if (comp != 0) {
/* 197 */         return comp;
/* 198 */       }
/* 199 */     }
/* 200 */
/* 201 */     return 0;
/* 202 */
/* 203 */   }
/* 204 */
/* 205 */
/* 206 */   public int compare(InternalRow a, InternalRow b) {
/* 207 */
/* 208 */     InternalRow i = null;
/* 209 */
/* 210 */     int comp = compare_0(a, b);
/* 211 */     if (comp != 0) {
/* 212 */       return comp;
/* 213 */     }
/* 214 */
/* 215 */     int comp1 = compare_1(a, b);
/* 216 */     if (comp1 != 0) {
/* 217 */       return comp1;
/* 218 */     }
/* 219 */
/* 220 */     int comp2 = compare_2(a, b);
/* 221 */     if (comp2 != 0) {
/* 222 */       return comp2;
/* 223 */     }
/* 224 */
/* 225 */
/* 226 */     return 0;
/* 227 */   }
/* 228 */ }
