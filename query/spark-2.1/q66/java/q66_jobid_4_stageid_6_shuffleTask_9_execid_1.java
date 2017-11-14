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
/* 025 */   private void apply_1(InternalRow i) {
/* 026 */
/* 027 */
/* 028 */     final double value6 = -1.0;
/* 029 */     if (true) {
/* 030 */       rowWriter.setNullAt(6);
/* 031 */     } else {
/* 032 */       rowWriter.write(6, value6);
/* 033 */     }
/* 034 */
/* 035 */
/* 036 */     final double value7 = -1.0;
/* 037 */     if (true) {
/* 038 */       rowWriter.setNullAt(7);
/* 039 */     } else {
/* 040 */       rowWriter.write(7, value7);
/* 041 */     }
/* 042 */
/* 043 */
/* 044 */     final double value8 = -1.0;
/* 045 */     if (true) {
/* 046 */       rowWriter.setNullAt(8);
/* 047 */     } else {
/* 048 */       rowWriter.write(8, value8);
/* 049 */     }
/* 050 */
/* 051 */
/* 052 */     final double value9 = -1.0;
/* 053 */     if (true) {
/* 054 */       rowWriter.setNullAt(9);
/* 055 */     } else {
/* 056 */       rowWriter.write(9, value9);
/* 057 */     }
/* 058 */
/* 059 */
/* 060 */     final double value10 = -1.0;
/* 061 */     if (true) {
/* 062 */       rowWriter.setNullAt(10);
/* 063 */     } else {
/* 064 */       rowWriter.write(10, value10);
/* 065 */     }
/* 066 */
/* 067 */
/* 068 */     final double value11 = -1.0;
/* 069 */     if (true) {
/* 070 */       rowWriter.setNullAt(11);
/* 071 */     } else {
/* 072 */       rowWriter.write(11, value11);
/* 073 */     }
/* 074 */
/* 075 */   }
/* 076 */
/* 077 */
/* 078 */   private void apply_3(InternalRow i) {
/* 079 */
/* 080 */
/* 081 */     final double value18 = -1.0;
/* 082 */     if (true) {
/* 083 */       rowWriter.setNullAt(18);
/* 084 */     } else {
/* 085 */       rowWriter.write(18, value18);
/* 086 */     }
/* 087 */
/* 088 */
/* 089 */     final double value19 = -1.0;
/* 090 */     if (true) {
/* 091 */       rowWriter.setNullAt(19);
/* 092 */     } else {
/* 093 */       rowWriter.write(19, value19);
/* 094 */     }
/* 095 */
/* 096 */
/* 097 */     final double value20 = -1.0;
/* 098 */     if (true) {
/* 099 */       rowWriter.setNullAt(20);
/* 100 */     } else {
/* 101 */       rowWriter.write(20, value20);
/* 102 */     }
/* 103 */
/* 104 */
/* 105 */     final double value21 = -1.0;
/* 106 */     if (true) {
/* 107 */       rowWriter.setNullAt(21);
/* 108 */     } else {
/* 109 */       rowWriter.write(21, value21);
/* 110 */     }
/* 111 */
/* 112 */
/* 113 */     final double value22 = -1.0;
/* 114 */     if (true) {
/* 115 */       rowWriter.setNullAt(22);
/* 116 */     } else {
/* 117 */       rowWriter.write(22, value22);
/* 118 */     }
/* 119 */
/* 120 */
/* 121 */     final double value23 = -1.0;
/* 122 */     if (true) {
/* 123 */       rowWriter.setNullAt(23);
/* 124 */     } else {
/* 125 */       rowWriter.write(23, value23);
/* 126 */     }
/* 127 */
/* 128 */   }
/* 129 */
/* 130 */
/* 131 */   private void apply_0(InternalRow i) {
/* 132 */
/* 133 */
/* 134 */     final double value = -1.0;
/* 135 */     if (true) {
/* 136 */       rowWriter.setNullAt(0);
/* 137 */     } else {
/* 138 */       rowWriter.write(0, value);
/* 139 */     }
/* 140 */
/* 141 */
/* 142 */     final double value1 = -1.0;
/* 143 */     if (true) {
/* 144 */       rowWriter.setNullAt(1);
/* 145 */     } else {
/* 146 */       rowWriter.write(1, value1);
/* 147 */     }
/* 148 */
/* 149 */
/* 150 */     final double value2 = -1.0;
/* 151 */     if (true) {
/* 152 */       rowWriter.setNullAt(2);
/* 153 */     } else {
/* 154 */       rowWriter.write(2, value2);
/* 155 */     }
/* 156 */
/* 157 */
/* 158 */     final double value3 = -1.0;
/* 159 */     if (true) {
/* 160 */       rowWriter.setNullAt(3);
/* 161 */     } else {
/* 162 */       rowWriter.write(3, value3);
/* 163 */     }
/* 164 */
/* 165 */
/* 166 */     final double value4 = -1.0;
/* 167 */     if (true) {
/* 168 */       rowWriter.setNullAt(4);
/* 169 */     } else {
/* 170 */       rowWriter.write(4, value4);
/* 171 */     }
/* 172 */
/* 173 */
/* 174 */     final double value5 = -1.0;
/* 175 */     if (true) {
/* 176 */       rowWriter.setNullAt(5);
/* 177 */     } else {
/* 178 */       rowWriter.write(5, value5);
/* 179 */     }
/* 180 */
/* 181 */   }
/* 182 */
/* 183 */
/* 184 */   private void apply_2(InternalRow i) {
/* 185 */
/* 186 */
/* 187 */     final double value12 = -1.0;
/* 188 */     if (true) {
/* 189 */       rowWriter.setNullAt(12);
/* 190 */     } else {
/* 191 */       rowWriter.write(12, value12);
/* 192 */     }
/* 193 */
/* 194 */
/* 195 */     final double value13 = -1.0;
/* 196 */     if (true) {
/* 197 */       rowWriter.setNullAt(13);
/* 198 */     } else {
/* 199 */       rowWriter.write(13, value13);
/* 200 */     }
/* 201 */
/* 202 */
/* 203 */     final double value14 = -1.0;
/* 204 */     if (true) {
/* 205 */       rowWriter.setNullAt(14);
/* 206 */     } else {
/* 207 */       rowWriter.write(14, value14);
/* 208 */     }
/* 209 */
/* 210 */
/* 211 */     final double value15 = -1.0;
/* 212 */     if (true) {
/* 213 */       rowWriter.setNullAt(15);
/* 214 */     } else {
/* 215 */       rowWriter.write(15, value15);
/* 216 */     }
/* 217 */
/* 218 */
/* 219 */     final double value16 = -1.0;
/* 220 */     if (true) {
/* 221 */       rowWriter.setNullAt(16);
/* 222 */     } else {
/* 223 */       rowWriter.write(16, value16);
/* 224 */     }
/* 225 */
/* 226 */
/* 227 */     final double value17 = -1.0;
/* 228 */     if (true) {
/* 229 */       rowWriter.setNullAt(17);
/* 230 */     } else {
/* 231 */       rowWriter.write(17, value17);
/* 232 */     }
/* 233 */
/* 234 */   }
/* 235 */
/* 236 */
/* 237 */   // Scala.Function1 need this
/* 238 */   public java.lang.Object apply(java.lang.Object row) {
/* 239 */     return apply((InternalRow) row);
/* 240 */   }
/* 241 */
/* 242 */   public UnsafeRow apply(InternalRow i) {
/* 243 */     rowWriter.zeroOutNullBytes();
/* 244 */     apply_0(i);
/* 245 */     apply_1(i);
/* 246 */     apply_2(i);
/* 247 */     apply_3(i);
/* 248 */     return result;
/* 249 */   }
/* 250 */ }
