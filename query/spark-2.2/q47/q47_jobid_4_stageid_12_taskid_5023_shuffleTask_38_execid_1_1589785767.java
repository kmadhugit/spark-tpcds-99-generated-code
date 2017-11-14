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
/* 022 */     int primitiveA4;
/* 023 */     {
/* 024 */
/* 025 */       int value4 = i.getInt(8);
/* 026 */       isNullA4 = false;
/* 027 */       primitiveA4 = value4;
/* 028 */     }
/* 029 */     i = b;
/* 030 */     boolean isNullB4;
/* 031 */     int primitiveB4;
/* 032 */     {
/* 033 */
/* 034 */       int value4 = i.getInt(8);
/* 035 */       isNullB4 = false;
/* 036 */       primitiveB4 = value4;
/* 037 */     }
/* 038 */     if (isNullA4 && isNullB4) {
/* 039 */       // Nothing
/* 040 */     } else if (isNullA4) {
/* 041 */       return -1;
/* 042 */     } else if (isNullB4) {
/* 043 */       return 1;
/* 044 */     } else {
/* 045 */       int comp = (primitiveA4 > primitiveB4 ? 1 : primitiveA4 < primitiveB4 ? -1 : 0);
/* 046 */       if (comp != 0) {
/* 047 */         return comp;
/* 048 */       }
/* 049 */     }
/* 050 */
/* 051 */     return 0;
/* 052 */
/* 053 */   }
/* 054 */
/* 055 */
/* 056 */   private int compare_1(InternalRow a, InternalRow b) {
/* 057 */
/* 058 */     InternalRow i = null;  // Holds current row being evaluated.
/* 059 */
/* 060 */     i = a;
/* 061 */     boolean isNullA2;
/* 062 */     UTF8String primitiveA2;
/* 063 */     {
/* 064 */
/* 065 */       boolean isNull2 = i.isNullAt(2);
/* 066 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 067 */       isNullA2 = isNull2;
/* 068 */       primitiveA2 = value2;
/* 069 */     }
/* 070 */     i = b;
/* 071 */     boolean isNullB2;
/* 072 */     UTF8String primitiveB2;
/* 073 */     {
/* 074 */
/* 075 */       boolean isNull2 = i.isNullAt(2);
/* 076 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 077 */       isNullB2 = isNull2;
/* 078 */       primitiveB2 = value2;
/* 079 */     }
/* 080 */     if (isNullA2 && isNullB2) {
/* 081 */       // Nothing
/* 082 */     } else if (isNullA2) {
/* 083 */       return -1;
/* 084 */     } else if (isNullB2) {
/* 085 */       return 1;
/* 086 */     } else {
/* 087 */       int comp = primitiveA2.compare(primitiveB2);
/* 088 */       if (comp != 0) {
/* 089 */         return comp;
/* 090 */       }
/* 091 */     }
/* 092 */
/* 093 */     i = a;
/* 094 */     boolean isNullA3;
/* 095 */     UTF8String primitiveA3;
/* 096 */     {
/* 097 */
/* 098 */       boolean isNull3 = i.isNullAt(3);
/* 099 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 100 */       isNullA3 = isNull3;
/* 101 */       primitiveA3 = value3;
/* 102 */     }
/* 103 */     i = b;
/* 104 */     boolean isNullB3;
/* 105 */     UTF8String primitiveB3;
/* 106 */     {
/* 107 */
/* 108 */       boolean isNull3 = i.isNullAt(3);
/* 109 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 110 */       isNullB3 = isNull3;
/* 111 */       primitiveB3 = value3;
/* 112 */     }
/* 113 */     if (isNullA3 && isNullB3) {
/* 114 */       // Nothing
/* 115 */     } else if (isNullA3) {
/* 116 */       return -1;
/* 117 */     } else if (isNullB3) {
/* 118 */       return 1;
/* 119 */     } else {
/* 120 */       int comp = primitiveA3.compare(primitiveB3);
/* 121 */       if (comp != 0) {
/* 122 */         return comp;
/* 123 */       }
/* 124 */     }
/* 125 */
/* 126 */     return 0;
/* 127 */
/* 128 */   }
/* 129 */
/* 130 */
/* 131 */   private int compare_0(InternalRow a, InternalRow b) {
/* 132 */
/* 133 */     InternalRow i = null;  // Holds current row being evaluated.
/* 134 */
/* 135 */     i = a;
/* 136 */     boolean isNullA;
/* 137 */     UTF8String primitiveA;
/* 138 */     {
/* 139 */
/* 140 */       boolean isNull = i.isNullAt(0);
/* 141 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 142 */       isNullA = isNull;
/* 143 */       primitiveA = value;
/* 144 */     }
/* 145 */     i = b;
/* 146 */     boolean isNullB;
/* 147 */     UTF8String primitiveB;
/* 148 */     {
/* 149 */
/* 150 */       boolean isNull = i.isNullAt(0);
/* 151 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 152 */       isNullB = isNull;
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
/* 170 */     UTF8String primitiveA1;
/* 171 */     {
/* 172 */
/* 173 */       boolean isNull1 = i.isNullAt(1);
/* 174 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 175 */       isNullA1 = isNull1;
/* 176 */       primitiveA1 = value1;
/* 177 */     }
/* 178 */     i = b;
/* 179 */     boolean isNullB1;
/* 180 */     UTF8String primitiveB1;
/* 181 */     {
/* 182 */
/* 183 */       boolean isNull1 = i.isNullAt(1);
/* 184 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
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
/* 195 */       int comp = primitiveA1.compare(primitiveB1);
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
