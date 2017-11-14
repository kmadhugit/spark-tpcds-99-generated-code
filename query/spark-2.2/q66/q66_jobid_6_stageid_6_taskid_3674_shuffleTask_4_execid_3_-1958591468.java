/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private UnsafeRow result;
/* 009 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 011 */
/* 012 */   public SpecificUnsafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     result = new UnsafeRow(24);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 24);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_4(InternalRow i) {
/* 026 */
/* 027 */
/* 028 */     boolean isNull16 = i.isNullAt(16);
/* 029 */     double value16 = isNull16 ? -1.0 : (i.getDouble(16));
/* 030 */     if (isNull16) {
/* 031 */       rowWriter.setNullAt(16);
/* 032 */     } else {
/* 033 */       rowWriter.write(16, value16);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull17 = i.isNullAt(17);
/* 038 */     double value17 = isNull17 ? -1.0 : (i.getDouble(17));
/* 039 */     if (isNull17) {
/* 040 */       rowWriter.setNullAt(17);
/* 041 */     } else {
/* 042 */       rowWriter.write(17, value17);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull18 = i.isNullAt(18);
/* 047 */     double value18 = isNull18 ? -1.0 : (i.getDouble(18));
/* 048 */     if (isNull18) {
/* 049 */       rowWriter.setNullAt(18);
/* 050 */     } else {
/* 051 */       rowWriter.write(18, value18);
/* 052 */     }
/* 053 */
/* 054 */
/* 055 */     boolean isNull19 = i.isNullAt(19);
/* 056 */     double value19 = isNull19 ? -1.0 : (i.getDouble(19));
/* 057 */     if (isNull19) {
/* 058 */       rowWriter.setNullAt(19);
/* 059 */     } else {
/* 060 */       rowWriter.write(19, value19);
/* 061 */     }
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */
/* 066 */   private void apply_1(InternalRow i) {
/* 067 */
/* 068 */
/* 069 */     boolean isNull4 = i.isNullAt(4);
/* 070 */     double value4 = isNull4 ? -1.0 : (i.getDouble(4));
/* 071 */     if (isNull4) {
/* 072 */       rowWriter.setNullAt(4);
/* 073 */     } else {
/* 074 */       rowWriter.write(4, value4);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     boolean isNull5 = i.isNullAt(5);
/* 079 */     double value5 = isNull5 ? -1.0 : (i.getDouble(5));
/* 080 */     if (isNull5) {
/* 081 */       rowWriter.setNullAt(5);
/* 082 */     } else {
/* 083 */       rowWriter.write(5, value5);
/* 084 */     }
/* 085 */
/* 086 */
/* 087 */     boolean isNull6 = i.isNullAt(6);
/* 088 */     double value6 = isNull6 ? -1.0 : (i.getDouble(6));
/* 089 */     if (isNull6) {
/* 090 */       rowWriter.setNullAt(6);
/* 091 */     } else {
/* 092 */       rowWriter.write(6, value6);
/* 093 */     }
/* 094 */
/* 095 */
/* 096 */     boolean isNull7 = i.isNullAt(7);
/* 097 */     double value7 = isNull7 ? -1.0 : (i.getDouble(7));
/* 098 */     if (isNull7) {
/* 099 */       rowWriter.setNullAt(7);
/* 100 */     } else {
/* 101 */       rowWriter.write(7, value7);
/* 102 */     }
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */
/* 107 */   private void apply_3(InternalRow i) {
/* 108 */
/* 109 */
/* 110 */     boolean isNull12 = i.isNullAt(12);
/* 111 */     double value12 = isNull12 ? -1.0 : (i.getDouble(12));
/* 112 */     if (isNull12) {
/* 113 */       rowWriter.setNullAt(12);
/* 114 */     } else {
/* 115 */       rowWriter.write(12, value12);
/* 116 */     }
/* 117 */
/* 118 */
/* 119 */     boolean isNull13 = i.isNullAt(13);
/* 120 */     double value13 = isNull13 ? -1.0 : (i.getDouble(13));
/* 121 */     if (isNull13) {
/* 122 */       rowWriter.setNullAt(13);
/* 123 */     } else {
/* 124 */       rowWriter.write(13, value13);
/* 125 */     }
/* 126 */
/* 127 */
/* 128 */     boolean isNull14 = i.isNullAt(14);
/* 129 */     double value14 = isNull14 ? -1.0 : (i.getDouble(14));
/* 130 */     if (isNull14) {
/* 131 */       rowWriter.setNullAt(14);
/* 132 */     } else {
/* 133 */       rowWriter.write(14, value14);
/* 134 */     }
/* 135 */
/* 136 */
/* 137 */     boolean isNull15 = i.isNullAt(15);
/* 138 */     double value15 = isNull15 ? -1.0 : (i.getDouble(15));
/* 139 */     if (isNull15) {
/* 140 */       rowWriter.setNullAt(15);
/* 141 */     } else {
/* 142 */       rowWriter.write(15, value15);
/* 143 */     }
/* 144 */
/* 145 */   }
/* 146 */
/* 147 */
/* 148 */   private void apply_0(InternalRow i) {
/* 149 */
/* 150 */
/* 151 */     boolean isNull = i.isNullAt(0);
/* 152 */     double value = isNull ? -1.0 : (i.getDouble(0));
/* 153 */     if (isNull) {
/* 154 */       rowWriter.setNullAt(0);
/* 155 */     } else {
/* 156 */       rowWriter.write(0, value);
/* 157 */     }
/* 158 */
/* 159 */
/* 160 */     boolean isNull1 = i.isNullAt(1);
/* 161 */     double value1 = isNull1 ? -1.0 : (i.getDouble(1));
/* 162 */     if (isNull1) {
/* 163 */       rowWriter.setNullAt(1);
/* 164 */     } else {
/* 165 */       rowWriter.write(1, value1);
/* 166 */     }
/* 167 */
/* 168 */
/* 169 */     boolean isNull2 = i.isNullAt(2);
/* 170 */     double value2 = isNull2 ? -1.0 : (i.getDouble(2));
/* 171 */     if (isNull2) {
/* 172 */       rowWriter.setNullAt(2);
/* 173 */     } else {
/* 174 */       rowWriter.write(2, value2);
/* 175 */     }
/* 176 */
/* 177 */
/* 178 */     boolean isNull3 = i.isNullAt(3);
/* 179 */     double value3 = isNull3 ? -1.0 : (i.getDouble(3));
/* 180 */     if (isNull3) {
/* 181 */       rowWriter.setNullAt(3);
/* 182 */     } else {
/* 183 */       rowWriter.write(3, value3);
/* 184 */     }
/* 185 */
/* 186 */   }
/* 187 */
/* 188 */
/* 189 */   private void apply_2(InternalRow i) {
/* 190 */
/* 191 */
/* 192 */     boolean isNull8 = i.isNullAt(8);
/* 193 */     double value8 = isNull8 ? -1.0 : (i.getDouble(8));
/* 194 */     if (isNull8) {
/* 195 */       rowWriter.setNullAt(8);
/* 196 */     } else {
/* 197 */       rowWriter.write(8, value8);
/* 198 */     }
/* 199 */
/* 200 */
/* 201 */     boolean isNull9 = i.isNullAt(9);
/* 202 */     double value9 = isNull9 ? -1.0 : (i.getDouble(9));
/* 203 */     if (isNull9) {
/* 204 */       rowWriter.setNullAt(9);
/* 205 */     } else {
/* 206 */       rowWriter.write(9, value9);
/* 207 */     }
/* 208 */
/* 209 */
/* 210 */     boolean isNull10 = i.isNullAt(10);
/* 211 */     double value10 = isNull10 ? -1.0 : (i.getDouble(10));
/* 212 */     if (isNull10) {
/* 213 */       rowWriter.setNullAt(10);
/* 214 */     } else {
/* 215 */       rowWriter.write(10, value10);
/* 216 */     }
/* 217 */
/* 218 */
/* 219 */     boolean isNull11 = i.isNullAt(11);
/* 220 */     double value11 = isNull11 ? -1.0 : (i.getDouble(11));
/* 221 */     if (isNull11) {
/* 222 */       rowWriter.setNullAt(11);
/* 223 */     } else {
/* 224 */       rowWriter.write(11, value11);
/* 225 */     }
/* 226 */
/* 227 */   }
/* 228 */
/* 229 */
/* 230 */   private void apply_5(InternalRow i) {
/* 231 */
/* 232 */
/* 233 */     boolean isNull20 = i.isNullAt(20);
/* 234 */     double value20 = isNull20 ? -1.0 : (i.getDouble(20));
/* 235 */     if (isNull20) {
/* 236 */       rowWriter.setNullAt(20);
/* 237 */     } else {
/* 238 */       rowWriter.write(20, value20);
/* 239 */     }
/* 240 */
/* 241 */
/* 242 */     boolean isNull21 = i.isNullAt(21);
/* 243 */     double value21 = isNull21 ? -1.0 : (i.getDouble(21));
/* 244 */     if (isNull21) {
/* 245 */       rowWriter.setNullAt(21);
/* 246 */     } else {
/* 247 */       rowWriter.write(21, value21);
/* 248 */     }
/* 249 */
/* 250 */
/* 251 */     boolean isNull22 = i.isNullAt(22);
/* 252 */     double value22 = isNull22 ? -1.0 : (i.getDouble(22));
/* 253 */     if (isNull22) {
/* 254 */       rowWriter.setNullAt(22);
/* 255 */     } else {
/* 256 */       rowWriter.write(22, value22);
/* 257 */     }
/* 258 */
/* 259 */
/* 260 */     boolean isNull23 = i.isNullAt(23);
/* 261 */     double value23 = isNull23 ? -1.0 : (i.getDouble(23));
/* 262 */     if (isNull23) {
/* 263 */       rowWriter.setNullAt(23);
/* 264 */     } else {
/* 265 */       rowWriter.write(23, value23);
/* 266 */     }
/* 267 */
/* 268 */   }
/* 269 */
/* 270 */
/* 271 */   // Scala.Function1 need this
/* 272 */   public java.lang.Object apply(java.lang.Object row) {
/* 273 */     return apply((InternalRow) row);
/* 274 */   }
/* 275 */
/* 276 */   public UnsafeRow apply(InternalRow i) {
/* 277 */     rowWriter.zeroOutNullBytes();
/* 278 */     apply_0(i);
/* 279 */     apply_1(i);
/* 280 */     apply_2(i);
/* 281 */     apply_3(i);
/* 282 */     apply_4(i);
/* 283 */     apply_5(i);
/* 284 */     return result;
/* 285 */   }
/* 286 */ }
