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
/* 022 */     double primitiveA4;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull4 = i.isNullAt(5);
/* 026 */       double value4 = isNull4 ? -1.0 : (i.getDouble(5));
/* 027 */       isNullA4 = isNull4;
/* 028 */       primitiveA4 = value4;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB4;
/* 032 */     double primitiveB4;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull4 = i.isNullAt(5);
/* 036 */       double value4 = isNull4 ? -1.0 : (i.getDouble(5));
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
/* 047 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA4, primitiveB4);
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
/* 064 */     UTF8String primitiveA2;
/* 065 */     {
/* 066 */
/* 067 */       boolean isNull2 = i.isNullAt(6);
/* 068 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(6));
/* 069 */       isNullA2 = isNull2;
/* 070 */       primitiveA2 = value2;
/* 071 */     }
/* 072 */     i = b;
/* 073 */     boolean isNullB2;
/* 074 */     UTF8String primitiveB2;
/* 075 */     {
/* 076 */
/* 077 */       boolean isNull2 = i.isNullAt(6);
/* 078 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(6));
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
/* 089 */       int comp = primitiveA2.compare(primitiveB2);
/* 090 */       if (comp != 0) {
/* 091 */         return comp;
/* 092 */       }
/* 093 */     }
/* 094 */
/* 095 */     i = a;
/* 096 */     boolean isNullA3;
/* 097 */     UTF8String primitiveA3;
/* 098 */     {
/* 099 */
/* 100 */       boolean isNull3 = i.isNullAt(0);
/* 101 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(0));
/* 102 */       isNullA3 = isNull3;
/* 103 */       primitiveA3 = value3;
/* 104 */     }
/* 105 */     i = b;
/* 106 */     boolean isNullB3;
/* 107 */     UTF8String primitiveB3;
/* 108 */     {
/* 109 */
/* 110 */       boolean isNull3 = i.isNullAt(0);
/* 111 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(0));
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
/* 122 */       int comp = primitiveA3.compare(primitiveB3);
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
/* 142 */       boolean isNull = i.isNullAt(1);
/* 143 */       UTF8String value = isNull ? null : (i.getUTF8String(1));
/* 144 */       isNullA = isNull;
/* 145 */       primitiveA = value;
/* 146 */     }
/* 147 */     i = b;
/* 148 */     boolean isNullB;
/* 149 */     UTF8String primitiveB;
/* 150 */     {
/* 151 */
/* 152 */       boolean isNull = i.isNullAt(1);
/* 153 */       UTF8String value = isNull ? null : (i.getUTF8String(1));
/* 154 */       isNullB = isNull;
/* 155 */       primitiveB = value;
/* 156 */     }
/* 157 */     if (isNullA && isNullB) {
/* 158 */       // Nothing
/* 159 */     } else if (isNullA) {
/* 160 */       return -1;
/* 161 */     } else if (isNullB) {
/* 162 */       return 1;
/* 163 */     } else {
/* 164 */       int comp = primitiveA.compare(primitiveB);
/* 165 */       if (comp != 0) {
/* 166 */         return comp;
/* 167 */       }
/* 168 */     }
/* 169 */
/* 170 */     i = a;
/* 171 */     boolean isNullA1;
/* 172 */     UTF8String primitiveA1;
/* 173 */     {
/* 174 */
/* 175 */       boolean isNull1 = i.isNullAt(2);
/* 176 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(2));
/* 177 */       isNullA1 = isNull1;
/* 178 */       primitiveA1 = value1;
/* 179 */     }
/* 180 */     i = b;
/* 181 */     boolean isNullB1;
/* 182 */     UTF8String primitiveB1;
/* 183 */     {
/* 184 */
/* 185 */       boolean isNull1 = i.isNullAt(2);
/* 186 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(2));
/* 187 */       isNullB1 = isNull1;
/* 188 */       primitiveB1 = value1;
/* 189 */     }
/* 190 */     if (isNullA1 && isNullB1) {
/* 191 */       // Nothing
/* 192 */     } else if (isNullA1) {
/* 193 */       return -1;
/* 194 */     } else if (isNullB1) {
/* 195 */       return 1;
/* 196 */     } else {
/* 197 */       int comp = primitiveA1.compare(primitiveB1);
/* 198 */       if (comp != 0) {
/* 199 */         return comp;
/* 200 */       }
/* 201 */     }
/* 202 */
/* 203 */     return 0;
/* 204 */
/* 205 */   }
/* 206 */
/* 207 */
/* 208 */   public int compare(InternalRow a, InternalRow b) {
/* 209 */
/* 210 */     InternalRow i = null;
/* 211 */
/* 212 */     int comp = compare_0(a, b);
/* 213 */     if (comp != 0) {
/* 214 */       return comp;
/* 215 */     }
/* 216 */
/* 217 */     int comp1 = compare_1(a, b);
/* 218 */     if (comp1 != 0) {
/* 219 */       return comp1;
/* 220 */     }
/* 221 */
/* 222 */     int comp2 = compare_2(a, b);
/* 223 */     if (comp2 != 0) {
/* 224 */       return comp2;
/* 225 */     }
/* 226 */
/* 227 */
/* 228 */     return 0;
/* 229 */   }
/* 230 */ }
