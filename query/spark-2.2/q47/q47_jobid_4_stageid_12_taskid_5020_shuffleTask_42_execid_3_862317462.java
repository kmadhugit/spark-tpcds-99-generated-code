/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private UTF8String smj_value12;
/* 013 */   private UTF8String smj_value13;
/* 014 */   private UTF8String smj_value14;
/* 015 */   private UTF8String smj_value15;
/* 016 */   private int smj_value16;
/* 017 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 018 */   private UTF8String smj_value17;
/* 019 */   private UTF8String smj_value18;
/* 020 */   private UTF8String smj_value19;
/* 021 */   private UTF8String smj_value20;
/* 022 */   private int smj_value21;
/* 023 */   private UTF8String smj_value22;
/* 024 */   private boolean smj_isNull12;
/* 025 */   private UTF8String smj_value23;
/* 026 */   private boolean smj_isNull13;
/* 027 */   private UTF8String smj_value24;
/* 028 */   private boolean smj_isNull14;
/* 029 */   private UTF8String smj_value25;
/* 030 */   private boolean smj_isNull15;
/* 031 */   private int smj_value26;
/* 032 */   private boolean smj_isNull16;
/* 033 */   private int smj_value27;
/* 034 */   private boolean smj_isNull17;
/* 035 */   private double smj_value28;
/* 036 */   private boolean smj_isNull18;
/* 037 */   private double smj_value29;
/* 038 */   private boolean smj_isNull19;
/* 039 */   private int smj_value30;
/* 040 */   private boolean smj_isNull20;
/* 041 */   private double smj_value31;
/* 042 */   private boolean smj_isNull21;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 044 */   private UnsafeRow smj_result;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 047 */   private UnsafeRow project_result;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 050 */
/* 051 */   public GeneratedIterator(Object[] references) {
/* 052 */     this.references = references;
/* 053 */   }
/* 054 */
/* 055 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 056 */     partitionIndex = index;
/* 057 */     this.inputs = inputs;
/* 058 */     smj_leftInput = inputs[0];
/* 059 */     smj_rightInput = inputs[1];
/* 060 */
/* 061 */     smj_rightRow = null;
/* 062 */
/* 063 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 064 */
/* 065 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 066 */     smj_result = new UnsafeRow(16);
/* 067 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 256);
/* 068 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 16);
/* 069 */     project_result = new UnsafeRow(10);
/* 070 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 071 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 10);
/* 072 */
/* 073 */   }
/* 074 */
/* 075 */   private boolean findNextInnerJoinRows(
/* 076 */     scala.collection.Iterator leftIter,
/* 077 */     scala.collection.Iterator rightIter) {
/* 078 */     smj_leftRow = null;
/* 079 */     int comp = 0;
/* 080 */     while (smj_leftRow == null) {
/* 081 */       if (!leftIter.hasNext()) return false;
/* 082 */       smj_leftRow = (InternalRow) leftIter.next();
/* 083 */
/* 084 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 085 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 086 */
/* 087 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 088 */       UTF8String smj_value1 = smj_isNull1 ? null : (smj_leftRow.getUTF8String(1));
/* 089 */
/* 090 */       boolean smj_isNull2 = smj_leftRow.isNullAt(2);
/* 091 */       UTF8String smj_value2 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(2));
/* 092 */
/* 093 */       boolean smj_isNull3 = smj_leftRow.isNullAt(3);
/* 094 */       UTF8String smj_value3 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(3));
/* 095 */
/* 096 */       boolean smj_isNull4 = smj_leftRow.isNullAt(8);
/* 097 */       int smj_value4 = smj_isNull4 ? -1 : (smj_leftRow.getInt(8));
/* 098 */       if (smj_isNull || smj_isNull1 || smj_isNull2 || smj_isNull3 || smj_isNull4) {
/* 099 */         smj_leftRow = null;
/* 100 */         continue;
/* 101 */       }
/* 102 */       if (!smj_matches.isEmpty()) {
/* 103 */         comp = 0;
/* 104 */         if (comp == 0) {
/* 105 */           comp = smj_value.compare(smj_value17);
/* 106 */         }
/* 107 */         if (comp == 0) {
/* 108 */           comp = smj_value1.compare(smj_value18);
/* 109 */         }
/* 110 */         if (comp == 0) {
/* 111 */           comp = smj_value2.compare(smj_value19);
/* 112 */         }
/* 113 */         if (comp == 0) {
/* 114 */           comp = smj_value3.compare(smj_value20);
/* 115 */         }
/* 116 */         if (comp == 0) {
/* 117 */           comp = (smj_value4 > smj_value21 ? 1 : smj_value4 < smj_value21 ? -1 : 0);
/* 118 */         }
/* 119 */
/* 120 */         if (comp == 0) {
/* 121 */           return true;
/* 122 */         }
/* 123 */         smj_matches.clear();
/* 124 */       }
/* 125 */
/* 126 */       do {
/* 127 */         if (smj_rightRow == null) {
/* 128 */           if (!rightIter.hasNext()) {
/* 129 */             smj_value17 = smj_value.clone();
/* 130 */             smj_value18 = smj_value1.clone();
/* 131 */             smj_value19 = smj_value2.clone();
/* 132 */             smj_value20 = smj_value3.clone();
/* 133 */             smj_value21 = smj_value4;
/* 134 */             return !smj_matches.isEmpty();
/* 135 */           }
/* 136 */           smj_rightRow = (InternalRow) rightIter.next();
/* 137 */
/* 138 */           boolean smj_isNull5 = smj_rightRow.isNullAt(0);
/* 139 */           UTF8String smj_value5 = smj_isNull5 ? null : (smj_rightRow.getUTF8String(0));
/* 140 */
/* 141 */           boolean smj_isNull6 = smj_rightRow.isNullAt(1);
/* 142 */           UTF8String smj_value6 = smj_isNull6 ? null : (smj_rightRow.getUTF8String(1));
/* 143 */
/* 144 */           boolean smj_isNull7 = smj_rightRow.isNullAt(2);
/* 145 */           UTF8String smj_value7 = smj_isNull7 ? null : (smj_rightRow.getUTF8String(2));
/* 146 */
/* 147 */           boolean smj_isNull8 = smj_rightRow.isNullAt(3);
/* 148 */           UTF8String smj_value8 = smj_isNull8 ? null : (smj_rightRow.getUTF8String(3));
/* 149 */
/* 150 */           boolean smj_isNull9 = true;
/* 151 */           int smj_value9 = -1;
/* 152 */
/* 153 */           boolean smj_isNull10 = smj_rightRow.isNullAt(5);
/* 154 */           int smj_value10 = smj_isNull10 ? -1 : (smj_rightRow.getInt(5));
/* 155 */           if (!smj_isNull10) {
/* 156 */             smj_isNull9 = false; // resultCode could change nullability.
/* 157 */             smj_value9 = smj_value10 - 1;
/* 158 */
/* 159 */           }
/* 160 */           if (smj_isNull5 || smj_isNull6 || smj_isNull7 || smj_isNull8 || smj_isNull9) {
/* 161 */             smj_rightRow = null;
/* 162 */             continue;
/* 163 */           }
/* 164 */           smj_value12 = smj_value5.clone();
/* 165 */           smj_value13 = smj_value6.clone();
/* 166 */           smj_value14 = smj_value7.clone();
/* 167 */           smj_value15 = smj_value8.clone();
/* 168 */           smj_value16 = smj_value9;
/* 169 */         }
/* 170 */
/* 171 */         comp = 0;
/* 172 */         if (comp == 0) {
/* 173 */           comp = smj_value.compare(smj_value12);
/* 174 */         }
/* 175 */         if (comp == 0) {
/* 176 */           comp = smj_value1.compare(smj_value13);
/* 177 */         }
/* 178 */         if (comp == 0) {
/* 179 */           comp = smj_value2.compare(smj_value14);
/* 180 */         }
/* 181 */         if (comp == 0) {
/* 182 */           comp = smj_value3.compare(smj_value15);
/* 183 */         }
/* 184 */         if (comp == 0) {
/* 185 */           comp = (smj_value4 > smj_value16 ? 1 : smj_value4 < smj_value16 ? -1 : 0);
/* 186 */         }
/* 187 */
/* 188 */         if (comp > 0) {
/* 189 */           smj_rightRow = null;
/* 190 */         } else if (comp < 0) {
/* 191 */           if (!smj_matches.isEmpty()) {
/* 192 */             smj_value17 = smj_value.clone();
/* 193 */             smj_value18 = smj_value1.clone();
/* 194 */             smj_value19 = smj_value2.clone();
/* 195 */             smj_value20 = smj_value3.clone();
/* 196 */             smj_value21 = smj_value4;
/* 197 */             return true;
/* 198 */           }
/* 199 */           smj_leftRow = null;
/* 200 */         } else {
/* 201 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 202 */           smj_rightRow = null;;
/* 203 */         }
/* 204 */       } while (smj_leftRow != null);
/* 205 */     }
/* 206 */     return false; // unreachable
/* 207 */   }
/* 208 */
/* 209 */   protected void processNext() throws java.io.IOException {
/* 210 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 211 */       smj_isNull12 = smj_leftRow.isNullAt(0);
/* 212 */       smj_value22 = smj_isNull12 ? null : (smj_leftRow.getUTF8String(0));
/* 213 */       smj_isNull13 = smj_leftRow.isNullAt(1);
/* 214 */       smj_value23 = smj_isNull13 ? null : (smj_leftRow.getUTF8String(1));
/* 215 */       smj_isNull14 = smj_leftRow.isNullAt(2);
/* 216 */       smj_value24 = smj_isNull14 ? null : (smj_leftRow.getUTF8String(2));
/* 217 */       smj_isNull15 = smj_leftRow.isNullAt(3);
/* 218 */       smj_value25 = smj_isNull15 ? null : (smj_leftRow.getUTF8String(3));
/* 219 */       smj_isNull16 = smj_leftRow.isNullAt(4);
/* 220 */       smj_value26 = smj_isNull16 ? -1 : (smj_leftRow.getInt(4));
/* 221 */       smj_isNull17 = smj_leftRow.isNullAt(5);
/* 222 */       smj_value27 = smj_isNull17 ? -1 : (smj_leftRow.getInt(5));
/* 223 */       smj_isNull18 = smj_leftRow.isNullAt(6);
/* 224 */       smj_value28 = smj_isNull18 ? -1.0 : (smj_leftRow.getDouble(6));
/* 225 */       smj_isNull19 = smj_leftRow.isNullAt(7);
/* 226 */       smj_value29 = smj_isNull19 ? -1.0 : (smj_leftRow.getDouble(7));
/* 227 */       smj_isNull20 = smj_leftRow.isNullAt(8);
/* 228 */       smj_value30 = smj_isNull20 ? -1 : (smj_leftRow.getInt(8));
/* 229 */       smj_isNull21 = smj_leftRow.isNullAt(9);
/* 230 */       smj_value31 = smj_isNull21 ? -1.0 : (smj_leftRow.getDouble(9));
/* 231 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 232 */       while (smj_iterator.hasNext()) {
/* 233 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 234 */
/* 235 */         smj_numOutputRows.add(1);
/* 236 */
/* 237 */         boolean smj_isNull26 = smj_rightRow1.isNullAt(4);
/* 238 */         double smj_value36 = smj_isNull26 ? -1.0 : (smj_rightRow1.getDouble(4));
/* 239 */         project_holder.reset();
/* 240 */
/* 241 */         project_rowWriter.zeroOutNullBytes();
/* 242 */
/* 243 */         if (smj_isNull12) {
/* 244 */           project_rowWriter.setNullAt(0);
/* 245 */         } else {
/* 246 */           project_rowWriter.write(0, smj_value22);
/* 247 */         }
/* 248 */
/* 249 */         if (smj_isNull13) {
/* 250 */           project_rowWriter.setNullAt(1);
/* 251 */         } else {
/* 252 */           project_rowWriter.write(1, smj_value23);
/* 253 */         }
/* 254 */
/* 255 */         if (smj_isNull14) {
/* 256 */           project_rowWriter.setNullAt(2);
/* 257 */         } else {
/* 258 */           project_rowWriter.write(2, smj_value24);
/* 259 */         }
/* 260 */
/* 261 */         if (smj_isNull15) {
/* 262 */           project_rowWriter.setNullAt(3);
/* 263 */         } else {
/* 264 */           project_rowWriter.write(3, smj_value25);
/* 265 */         }
/* 266 */
/* 267 */         if (smj_isNull16) {
/* 268 */           project_rowWriter.setNullAt(4);
/* 269 */         } else {
/* 270 */           project_rowWriter.write(4, smj_value26);
/* 271 */         }
/* 272 */
/* 273 */         if (smj_isNull17) {
/* 274 */           project_rowWriter.setNullAt(5);
/* 275 */         } else {
/* 276 */           project_rowWriter.write(5, smj_value27);
/* 277 */         }
/* 278 */
/* 279 */         if (smj_isNull19) {
/* 280 */           project_rowWriter.setNullAt(6);
/* 281 */         } else {
/* 282 */           project_rowWriter.write(6, smj_value29);
/* 283 */         }
/* 284 */
/* 285 */         if (smj_isNull18) {
/* 286 */           project_rowWriter.setNullAt(7);
/* 287 */         } else {
/* 288 */           project_rowWriter.write(7, smj_value28);
/* 289 */         }
/* 290 */
/* 291 */         if (smj_isNull21) {
/* 292 */           project_rowWriter.setNullAt(8);
/* 293 */         } else {
/* 294 */           project_rowWriter.write(8, smj_value31);
/* 295 */         }
/* 296 */
/* 297 */         if (smj_isNull26) {
/* 298 */           project_rowWriter.setNullAt(9);
/* 299 */         } else {
/* 300 */           project_rowWriter.write(9, smj_value36);
/* 301 */         }
/* 302 */         project_result.setTotalSize(project_holder.totalSize());
/* 303 */         append(project_result.copy());
/* 304 */
/* 305 */       }
/* 306 */       if (shouldStop()) return;
/* 307 */     }
/* 308 */   }
/* 309 */ }
