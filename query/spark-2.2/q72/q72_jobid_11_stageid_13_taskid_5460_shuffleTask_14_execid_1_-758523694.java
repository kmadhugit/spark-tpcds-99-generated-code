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
/* 012 */   private int smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private int smj_value3;
/* 015 */   private int smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private int smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private int smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private int smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private int smj_value8;
/* 024 */   private boolean smj_isNull6;
/* 025 */   private int smj_value9;
/* 026 */   private boolean smj_isNull7;
/* 027 */   private int smj_value10;
/* 028 */   private boolean smj_isNull8;
/* 029 */   private int smj_value11;
/* 030 */   private boolean smj_isNull9;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 032 */   private UnsafeRow smj_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 039 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 041 */   private UnsafeRow bhj_result;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 044 */   private UnsafeRow project_result1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 047 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 048 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 049 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 050 */   private UnsafeRow bhj_result1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 053 */   private UnsafeRow project_result2;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 056 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 057 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 058 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 059 */   private UnsafeRow bhj_result2;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 062 */   private UnsafeRow project_result3;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 065 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 066 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 067 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 068 */   private UnsafeRow bhj_result3;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 071 */   private UnsafeRow project_result4;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 074 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 075 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation4;
/* 076 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 077 */   private UnsafeRow bhj_result4;
/* 078 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 080 */   private UnsafeRow project_result5;
/* 081 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder5;
/* 082 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter5;
/* 083 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast5;
/* 084 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation5;
/* 085 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows5;
/* 086 */   private UnsafeRow bhj_result5;
/* 087 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder5;
/* 088 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter5;
/* 089 */   private UnsafeRow project_result6;
/* 090 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder6;
/* 091 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter6;
/* 092 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast6;
/* 093 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation6;
/* 094 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows6;
/* 095 */   private UnsafeRow bhj_result6;
/* 096 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder6;
/* 097 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter6;
/* 098 */   private UnsafeRow project_result7;
/* 099 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder7;
/* 100 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter7;
/* 101 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast7;
/* 102 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation7;
/* 103 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows7;
/* 104 */   private UnsafeRow bhj_result7;
/* 105 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder7;
/* 106 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter7;
/* 107 */   private UnsafeRow project_result8;
/* 108 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder8;
/* 109 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter8;
/* 110 */
/* 111 */   public GeneratedIterator(Object[] references) {
/* 112 */     this.references = references;
/* 113 */   }
/* 114 */
/* 115 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 116 */     partitionIndex = index;
/* 117 */     this.inputs = inputs;
/* 118 */     wholestagecodegen_init_0();
/* 119 */     wholestagecodegen_init_1();
/* 120 */     wholestagecodegen_init_2();
/* 121 */     wholestagecodegen_init_3();
/* 122 */     wholestagecodegen_init_4();
/* 123 */     wholestagecodegen_init_5();
/* 124 */     wholestagecodegen_init_6();
/* 125 */     wholestagecodegen_init_7();
/* 126 */
/* 127 */   }
/* 128 */
/* 129 */   private void wholestagecodegen_init_0() {
/* 130 */     smj_leftInput = inputs[0];
/* 131 */     smj_rightInput = inputs[1];
/* 132 */
/* 133 */     smj_rightRow = null;
/* 134 */
/* 135 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 136 */
/* 137 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 138 */     smj_result = new UnsafeRow(12);
/* 139 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 140 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 12);
/* 141 */     project_result = new UnsafeRow(9);
/* 142 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 143 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 9);
/* 144 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[1];
/* 145 */
/* 146 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 147 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 148 */
/* 149 */   }
/* 150 */
/* 151 */   private void wholestagecodegen_init_3() {
/* 152 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 9);
/* 153 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[7];
/* 154 */
/* 155 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 156 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 157 */
/* 158 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 159 */     bhj_result3 = new UnsafeRow(10);
/* 160 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 64);
/* 161 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 10);
/* 162 */     project_result4 = new UnsafeRow(8);
/* 163 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 64);
/* 164 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 8);
/* 165 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 166 */
/* 167 */   }
/* 168 */
/* 169 */   private boolean findNextInnerJoinRows(
/* 170 */     scala.collection.Iterator leftIter,
/* 171 */     scala.collection.Iterator rightIter) {
/* 172 */     smj_leftRow = null;
/* 173 */     int comp = 0;
/* 174 */     while (smj_leftRow == null) {
/* 175 */       if (!leftIter.hasNext()) return false;
/* 176 */       smj_leftRow = (InternalRow) leftIter.next();
/* 177 */
/* 178 */       boolean smj_isNull = smj_leftRow.isNullAt(3);
/* 179 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(3));
/* 180 */       if (smj_isNull) {
/* 181 */         smj_leftRow = null;
/* 182 */         continue;
/* 183 */       }
/* 184 */       if (!smj_matches.isEmpty()) {
/* 185 */         comp = 0;
/* 186 */         if (comp == 0) {
/* 187 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 188 */         }
/* 189 */
/* 190 */         if (comp == 0) {
/* 191 */           return true;
/* 192 */         }
/* 193 */         smj_matches.clear();
/* 194 */       }
/* 195 */
/* 196 */       do {
/* 197 */         if (smj_rightRow == null) {
/* 198 */           if (!rightIter.hasNext()) {
/* 199 */             smj_value3 = smj_value;
/* 200 */             return !smj_matches.isEmpty();
/* 201 */           }
/* 202 */           smj_rightRow = (InternalRow) rightIter.next();
/* 203 */
/* 204 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 205 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 206 */           if (smj_isNull1) {
/* 207 */             smj_rightRow = null;
/* 208 */             continue;
/* 209 */           }
/* 210 */           smj_value2 = smj_value1;
/* 211 */         }
/* 212 */
/* 213 */         comp = 0;
/* 214 */         if (comp == 0) {
/* 215 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 216 */         }
/* 217 */
/* 218 */         if (comp > 0) {
/* 219 */           smj_rightRow = null;
/* 220 */         } else if (comp < 0) {
/* 221 */           if (!smj_matches.isEmpty()) {
/* 222 */             smj_value3 = smj_value;
/* 223 */             return true;
/* 224 */           }
/* 225 */           smj_leftRow = null;
/* 226 */         } else {
/* 227 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 228 */           smj_rightRow = null;;
/* 229 */         }
/* 230 */       } while (smj_leftRow != null);
/* 231 */     }
/* 232 */     return false; // unreachable
/* 233 */   }
/* 234 */
/* 235 */   private void wholestagecodegen_init_5() {
/* 236 */     this.bhj_numOutputRows5 = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 237 */     bhj_result5 = new UnsafeRow(11);
/* 238 */     this.bhj_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result5, 96);
/* 239 */     this.bhj_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder5, 11);
/* 240 */     project_result6 = new UnsafeRow(8);
/* 241 */     this.project_holder6 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result6, 96);
/* 242 */     this.project_rowWriter6 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder6, 8);
/* 243 */     this.bhj_broadcast6 = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 244 */
/* 245 */     bhj_relation6 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast6.value()).asReadOnlyCopy();
/* 246 */     incPeakExecutionMemory(bhj_relation6.estimatedSize());
/* 247 */
/* 248 */     this.bhj_numOutputRows6 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 249 */     bhj_result6 = new UnsafeRow(10);
/* 250 */     this.bhj_holder6 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result6, 128);
/* 251 */
/* 252 */   }
/* 253 */
/* 254 */   private void wholestagecodegen_init_2() {
/* 255 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 11);
/* 256 */     project_result2 = new UnsafeRow(10);
/* 257 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 258 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 10);
/* 259 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 260 */
/* 261 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 262 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 263 */
/* 264 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 265 */     bhj_result2 = new UnsafeRow(11);
/* 266 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 64);
/* 267 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 11);
/* 268 */     project_result3 = new UnsafeRow(9);
/* 269 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 64);
/* 270 */
/* 271 */   }
/* 272 */
/* 273 */   private void wholestagecodegen_init_1() {
/* 274 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 275 */     bhj_result = new UnsafeRow(11);
/* 276 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 277 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 11);
/* 278 */     project_result1 = new UnsafeRow(9);
/* 279 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 280 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 9);
/* 281 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 282 */
/* 283 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 284 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 285 */
/* 286 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 287 */     bhj_result1 = new UnsafeRow(11);
/* 288 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 289 */
/* 290 */   }
/* 291 */
/* 292 */   private void wholestagecodegen_init_4() {
/* 293 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 294 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 295 */
/* 296 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 297 */     bhj_result4 = new UnsafeRow(11);
/* 298 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 96);
/* 299 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 11);
/* 300 */     project_result5 = new UnsafeRow(9);
/* 301 */     this.project_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result5, 96);
/* 302 */     this.project_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder5, 9);
/* 303 */     this.bhj_broadcast5 = (org.apache.spark.broadcast.TorrentBroadcast) references[11];
/* 304 */
/* 305 */     bhj_relation5 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast5.value()).asReadOnlyCopy();
/* 306 */     incPeakExecutionMemory(bhj_relation5.estimatedSize());
/* 307 */
/* 308 */   }
/* 309 */
/* 310 */   private void wholestagecodegen_init_7() {
/* 311 */     this.project_rowWriter8 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder8, 5);
/* 312 */
/* 313 */   }
/* 314 */
/* 315 */   private void wholestagecodegen_init_6() {
/* 316 */     this.bhj_rowWriter6 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder6, 10);
/* 317 */     project_result7 = new UnsafeRow(6);
/* 318 */     this.project_holder7 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result7, 64);
/* 319 */     this.project_rowWriter7 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder7, 6);
/* 320 */     this.bhj_broadcast7 = (org.apache.spark.broadcast.TorrentBroadcast) references[19];
/* 321 */
/* 322 */     bhj_relation7 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast7.value()).asReadOnlyCopy();
/* 323 */     incPeakExecutionMemory(bhj_relation7.estimatedSize());
/* 324 */
/* 325 */     this.bhj_numOutputRows7 = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 326 */     bhj_result7 = new UnsafeRow(7);
/* 327 */     this.bhj_holder7 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result7, 64);
/* 328 */     this.bhj_rowWriter7 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder7, 7);
/* 329 */     project_result8 = new UnsafeRow(5);
/* 330 */     this.project_holder8 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result8, 64);
/* 331 */
/* 332 */   }
/* 333 */
/* 334 */   protected void processNext() throws java.io.IOException {
/* 335 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 336 */       boolean smj_loaded = false;
/* 337 */       smj_isNull8 = smj_leftRow.isNullAt(6);
/* 338 */       smj_value10 = smj_isNull8 ? -1 : (smj_leftRow.getInt(6));
/* 339 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 340 */       while (smj_iterator.hasNext()) {
/* 341 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 342 */         boolean smj_isNull12 = smj_rightRow1.isNullAt(2);
/* 343 */         int smj_value14 = smj_isNull12 ? -1 : (smj_rightRow1.getInt(2));
/* 344 */
/* 345 */         boolean smj_isNull14 = true;
/* 346 */         boolean smj_value16 = false;
/* 347 */
/* 348 */         if (!smj_isNull12) {
/* 349 */           if (!smj_isNull8) {
/* 350 */             smj_isNull14 = false; // resultCode could change nullability.
/* 351 */             smj_value16 = smj_value14 < smj_value10;
/* 352 */
/* 353 */           }
/* 354 */
/* 355 */         }
/* 356 */         if (smj_isNull14 || !smj_value16) continue;
/* 357 */         if (!smj_loaded) {
/* 358 */           smj_loaded = true;
/* 359 */           smj_isNull2 = smj_leftRow.isNullAt(0);
/* 360 */           smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 361 */           smj_isNull3 = smj_leftRow.isNullAt(1);
/* 362 */           smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 363 */           smj_isNull4 = smj_leftRow.isNullAt(2);
/* 364 */           smj_value6 = smj_isNull4 ? -1 : (smj_leftRow.getInt(2));
/* 365 */           smj_isNull5 = smj_leftRow.isNullAt(3);
/* 366 */           smj_value7 = smj_isNull5 ? -1 : (smj_leftRow.getInt(3));
/* 367 */           smj_isNull6 = smj_leftRow.isNullAt(4);
/* 368 */           smj_value8 = smj_isNull6 ? -1 : (smj_leftRow.getInt(4));
/* 369 */           smj_isNull7 = smj_leftRow.isNullAt(5);
/* 370 */           smj_value9 = smj_isNull7 ? -1 : (smj_leftRow.getInt(5));
/* 371 */           smj_isNull9 = smj_leftRow.isNullAt(7);
/* 372 */           smj_value11 = smj_isNull9 ? -1 : (smj_leftRow.getInt(7));
/* 373 */         }
/* 374 */         boolean smj_isNull10 = smj_rightRow1.isNullAt(0);
/* 375 */         int smj_value12 = smj_isNull10 ? -1 : (smj_rightRow1.getInt(0));
/* 376 */         boolean smj_isNull11 = smj_rightRow1.isNullAt(1);
/* 377 */         int smj_value13 = smj_isNull11 ? -1 : (smj_rightRow1.getInt(1));
/* 378 */         boolean smj_isNull13 = smj_rightRow1.isNullAt(3);
/* 379 */         int smj_value15 = smj_isNull13 ? -1 : (smj_rightRow1.getInt(3));
/* 380 */         smj_numOutputRows.add(1);
/* 381 */
/* 382 */         // generate join key for stream side
/* 383 */
/* 384 */         boolean bhj_isNull = smj_isNull11;
/* 385 */         long bhj_value = -1L;
/* 386 */         if (!smj_isNull11) {
/* 387 */           bhj_value = (long) smj_value13;
/* 388 */         }
/* 389 */         // find matches from HashedRelation
/* 390 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 391 */         if (bhj_matched == null) continue;
/* 392 */
/* 393 */         bhj_numOutputRows.add(1);
/* 394 */
/* 395 */         // generate join key for stream side
/* 396 */
/* 397 */         boolean bhj_isNull15 = smj_isNull5;
/* 398 */         long bhj_value15 = -1L;
/* 399 */         if (!smj_isNull5) {
/* 400 */           bhj_value15 = (long) smj_value7;
/* 401 */         }
/* 402 */         // find matches from HashedRelation
/* 403 */         UnsafeRow bhj_matched1 = bhj_isNull15 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value15);
/* 404 */         if (bhj_matched1 == null) continue;
/* 405 */
/* 406 */         bhj_numOutputRows1.add(1);
/* 407 */
/* 408 */         // generate join key for stream side
/* 409 */
/* 410 */         boolean bhj_isNull30 = smj_isNull3;
/* 411 */         long bhj_value30 = -1L;
/* 412 */         if (!smj_isNull3) {
/* 413 */           bhj_value30 = (long) smj_value5;
/* 414 */         }
/* 415 */         // find matches from HashedRelation
/* 416 */         UnsafeRow bhj_matched2 = bhj_isNull30 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value30);
/* 417 */         if (bhj_matched2 == null) continue;
/* 418 */
/* 419 */         bhj_numOutputRows2.add(1);
/* 420 */
/* 421 */         // generate join key for stream side
/* 422 */
/* 423 */         boolean bhj_isNull44 = smj_isNull4;
/* 424 */         long bhj_value44 = -1L;
/* 425 */         if (!smj_isNull4) {
/* 426 */           bhj_value44 = (long) smj_value6;
/* 427 */         }
/* 428 */         // find matches from HashedRelation
/* 429 */         UnsafeRow bhj_matched3 = bhj_isNull44 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value44);
/* 430 */         if (bhj_matched3 == null) continue;
/* 431 */
/* 432 */         bhj_numOutputRows3.add(1);
/* 433 */
/* 434 */         // generate join key for stream side
/* 435 */
/* 436 */         boolean bhj_isNull57 = smj_isNull9;
/* 437 */         long bhj_value57 = -1L;
/* 438 */         if (!smj_isNull9) {
/* 439 */           bhj_value57 = (long) smj_value11;
/* 440 */         }
/* 441 */         // find matches from HashedRelation
/* 442 */         UnsafeRow bhj_matched4 = bhj_isNull57 ? null: (UnsafeRow)bhj_relation4.getValue(bhj_value57);
/* 443 */         if (bhj_matched4 == null) continue;
/* 444 */
/* 445 */         bhj_numOutputRows4.add(1);
/* 446 */
/* 447 */         boolean bhj_isNull61 = bhj_matched4.isNullAt(2);
/* 448 */         int bhj_value61 = bhj_isNull61 ? -1 : (bhj_matched4.getInt(2));
/* 449 */
/* 450 */         // generate join key for stream side
/* 451 */
/* 452 */         boolean bhj_isNull73 = true;
/* 453 */         long bhj_value73 = -1L;
/* 454 */
/* 455 */         boolean bhj_isNull74 = true;
/* 456 */         long bhj_value74 = -1L;
/* 457 */
/* 458 */         boolean bhj_isNull75 = bhj_isNull61;
/* 459 */         long bhj_value75 = -1L;
/* 460 */         if (!bhj_isNull61) {
/* 461 */           bhj_value75 = (long) bhj_value61;
/* 462 */         }
/* 463 */         if (!bhj_isNull75) {
/* 464 */           bhj_isNull74 = false; // resultCode could change nullability.
/* 465 */           bhj_value74 = bhj_value75 << 32;
/* 466 */
/* 467 */         }
/* 468 */         if (!bhj_isNull74) {
/* 469 */           boolean bhj_isNull78 = true;
/* 470 */           long bhj_value78 = -1L;
/* 471 */
/* 472 */           boolean bhj_isNull79 = smj_isNull13;
/* 473 */           long bhj_value79 = -1L;
/* 474 */           if (!smj_isNull13) {
/* 475 */             bhj_value79 = (long) smj_value15;
/* 476 */           }
/* 477 */           if (!bhj_isNull79) {
/* 478 */             bhj_isNull78 = false; // resultCode could change nullability.
/* 479 */             bhj_value78 = bhj_value79 & 4294967295L;
/* 480 */
/* 481 */           }
/* 482 */           if (!bhj_isNull78) {
/* 483 */             bhj_isNull73 = false; // resultCode could change nullability.
/* 484 */             bhj_value73 = bhj_value74 | bhj_value78;
/* 485 */
/* 486 */           }
/* 487 */
/* 488 */         }
/* 489 */         // find matches from HashedRelation
/* 490 */         UnsafeRow bhj_matched5 = bhj_isNull73 ? null: (UnsafeRow)bhj_relation5.getValue(bhj_value73);
/* 491 */         if (bhj_matched5 == null) continue;
/* 492 */
/* 493 */         bhj_numOutputRows5.add(1);
/* 494 */
/* 495 */         boolean bhj_isNull60 = bhj_matched4.isNullAt(1);
/* 496 */         UTF8String bhj_value60 = bhj_isNull60 ? null : (bhj_matched4.getUTF8String(1));
/* 497 */
/* 498 */         // generate join key for stream side
/* 499 */
/* 500 */         boolean bhj_isNull95 = smj_isNull2;
/* 501 */         long bhj_value95 = -1L;
/* 502 */         if (!smj_isNull2) {
/* 503 */           bhj_value95 = (long) smj_value4;
/* 504 */         }
/* 505 */         // find matches from HashedRelation
/* 506 */         UnsafeRow bhj_matched6 = bhj_isNull95 ? null: (UnsafeRow)bhj_relation6.getValue(bhj_value95);
/* 507 */         if (bhj_matched6 == null) continue;
/* 508 */
/* 509 */         boolean bhj_isNull98 = bhj_matched6.isNullAt(1);
/* 510 */         UTF8String bhj_value98 = bhj_isNull98 ? null : (bhj_matched6.getUTF8String(1));
/* 511 */
/* 512 */         boolean bhj_isNull99 = true;
/* 513 */         boolean bhj_value99 = false;
/* 514 */
/* 515 */         if (!bhj_isNull98) {
/* 516 */           boolean bhj_isNull103 = true;
/* 517 */           long bhj_value103 = -1L;
/* 518 */
/* 519 */           boolean bhj_isNull105 = bhj_isNull60;
/* 520 */           int bhj_value105 = -1;
/* 521 */           if (!bhj_isNull60) {
/* 522 */             scala.Option<Integer> bhj_intOpt =
/* 523 */             org.apache.spark.sql.catalyst.util.DateTimeUtils.stringToDate(bhj_value60);
/* 524 */             if (bhj_intOpt.isDefined()) {
/* 525 */               bhj_value105 = ((Integer) bhj_intOpt.get()).intValue();
/* 526 */             } else {
/* 527 */               bhj_isNull105 = true;
/* 528 */             }
/* 529 */
/* 530 */           }
/* 531 */           boolean bhj_isNull104 = bhj_isNull105;
/* 532 */           long bhj_value104 = -1L;
/* 533 */           if (!bhj_isNull105) {
/* 534 */             bhj_value104 = org.apache.spark.sql.catalyst.util.DateTimeUtils.daysToMillis(bhj_value105, ((sun.util.calendar.ZoneInfo) references[15])) * 1000;
/* 535 */           }
/* 536 */           if (!bhj_isNull104) {
/* 537 */             bhj_isNull103 = false; // resultCode could change nullability.
/* 538 */             bhj_value103 = org.apache.spark.sql.catalyst.util.DateTimeUtils.timestampAddInterval(bhj_value104, ((CalendarInterval) references[16]).months, ((CalendarInterval) references[16]).microseconds, ((sun.util.calendar.ZoneInfo) references[14]));
/* 539 */
/* 540 */           }
/* 541 */           boolean bhj_isNull102 = bhj_isNull103;
/* 542 */           int bhj_value102 = -1;
/* 543 */           if (!bhj_isNull103) {
/* 544 */             bhj_value102 = org.apache.spark.sql.catalyst.util.DateTimeUtils.millisToDays(bhj_value103 / 1000L, ((sun.util.calendar.ZoneInfo) references[17]));
/* 545 */           }
/* 546 */           boolean bhj_isNull101 = bhj_isNull102;
/* 547 */           UTF8String bhj_value101 = null;
/* 548 */           if (!bhj_isNull102) {
/* 549 */             bhj_value101 = UTF8String.fromString(
/* 550 */               org.apache.spark.sql.catalyst.util.DateTimeUtils.dateToString(bhj_value102));
/* 551 */           }
/* 552 */           if (!bhj_isNull101) {
/* 553 */             bhj_isNull99 = false; // resultCode could change nullability.
/* 554 */             bhj_value99 = bhj_value98.compare(bhj_value101) > 0;
/* 555 */
/* 556 */           }
/* 557 */
/* 558 */         }
/* 559 */         if (bhj_isNull99 || !bhj_value99) continue;
/* 560 */
/* 561 */         bhj_numOutputRows6.add(1);
/* 562 */
/* 563 */         // generate join key for stream side
/* 564 */
/* 565 */         boolean bhj_isNull118 = smj_isNull6;
/* 566 */         long bhj_value118 = -1L;
/* 567 */         if (!smj_isNull6) {
/* 568 */           bhj_value118 = (long) smj_value8;
/* 569 */         }
/* 570 */         // find matches from HashedRelation
/* 571 */         UnsafeRow bhj_matched7 = bhj_isNull118 ? null: (UnsafeRow)bhj_relation7.getValue(bhj_value118);
/* 572 */         final boolean bhj_conditionPassed = true;
/* 573 */         if (!bhj_conditionPassed) {
/* 574 */           bhj_matched7 = null;
/* 575 */           // reset the variables those are already evaluated.
/* 576 */
/* 577 */         }
/* 578 */         bhj_numOutputRows7.add(1);
/* 579 */
/* 580 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 581 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 582 */         boolean bhj_isNull18 = bhj_matched1.isNullAt(1);
/* 583 */         UTF8String bhj_value18 = bhj_isNull18 ? null : (bhj_matched1.getUTF8String(1));
/* 584 */         project_holder8.reset();
/* 585 */
/* 586 */         project_rowWriter8.zeroOutNullBytes();
/* 587 */
/* 588 */         if (smj_isNull5) {
/* 589 */           project_rowWriter8.setNullAt(0);
/* 590 */         } else {
/* 591 */           project_rowWriter8.write(0, smj_value7);
/* 592 */         }
/* 593 */
/* 594 */         if (smj_isNull7) {
/* 595 */           project_rowWriter8.setNullAt(1);
/* 596 */         } else {
/* 597 */           project_rowWriter8.write(1, smj_value9);
/* 598 */         }
/* 599 */
/* 600 */         if (bhj_isNull3) {
/* 601 */           project_rowWriter8.setNullAt(2);
/* 602 */         } else {
/* 603 */           project_rowWriter8.write(2, bhj_value3);
/* 604 */         }
/* 605 */
/* 606 */         if (bhj_isNull18) {
/* 607 */           project_rowWriter8.setNullAt(3);
/* 608 */         } else {
/* 609 */           project_rowWriter8.write(3, bhj_value18);
/* 610 */         }
/* 611 */
/* 612 */         if (bhj_isNull61) {
/* 613 */           project_rowWriter8.setNullAt(4);
/* 614 */         } else {
/* 615 */           project_rowWriter8.write(4, bhj_value61);
/* 616 */         }
/* 617 */         project_result8.setTotalSize(project_holder8.totalSize());
/* 618 */         append(project_result8.copy());
/* 619 */
/* 620 */       }
/* 621 */       if (shouldStop()) return;
/* 622 */     }
/* 623 */   }
/* 624 */ }
