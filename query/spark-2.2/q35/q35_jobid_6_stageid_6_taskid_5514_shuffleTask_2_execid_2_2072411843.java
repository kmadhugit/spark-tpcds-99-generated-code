/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance9;
/* 024 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance10;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance11;
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance12;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance13;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance14;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance15;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance16;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance17;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance18;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance19;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance20;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance21;
/* 036 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance22;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance23;
/* 038 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance24;
/* 039 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance25;
/* 040 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance26;
/* 041 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance27;
/* 042 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance28;
/* 043 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance29;
/* 044 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance30;
/* 045 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance31;
/* 046 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance32;
/* 047 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance33;
/* 048 */   private UnsafeRow scan_result;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 051 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 052 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 053 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 054 */   private UnsafeRow bhj_result;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 057 */
/* 058 */   public GeneratedIterator(Object[] references) {
/* 059 */     this.references = references;
/* 060 */   }
/* 061 */
/* 062 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 063 */     partitionIndex = index;
/* 064 */     this.inputs = inputs;
/* 065 */     wholestagecodegen_init_0();
/* 066 */     wholestagecodegen_init_1();
/* 067 */
/* 068 */   }
/* 069 */
/* 070 */   private void wholestagecodegen_init_0() {
/* 071 */     scan_input = inputs[0];
/* 072 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 073 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 074 */     scan_scanTime1 = 0;
/* 075 */     scan_batch = null;
/* 076 */     scan_batchIdx = 0;
/* 077 */     scan_colInstance0 = null;
/* 078 */     scan_colInstance1 = null;
/* 079 */     scan_colInstance2 = null;
/* 080 */     scan_colInstance3 = null;
/* 081 */     scan_colInstance4 = null;
/* 082 */     scan_colInstance5 = null;
/* 083 */     scan_colInstance6 = null;
/* 084 */     scan_colInstance7 = null;
/* 085 */     scan_colInstance8 = null;
/* 086 */     scan_colInstance9 = null;
/* 087 */     scan_colInstance10 = null;
/* 088 */     scan_colInstance11 = null;
/* 089 */     scan_colInstance12 = null;
/* 090 */     scan_colInstance13 = null;
/* 091 */     scan_colInstance14 = null;
/* 092 */     scan_colInstance15 = null;
/* 093 */     scan_colInstance16 = null;
/* 094 */     scan_colInstance17 = null;
/* 095 */     scan_colInstance18 = null;
/* 096 */     scan_colInstance19 = null;
/* 097 */     scan_colInstance20 = null;
/* 098 */     scan_colInstance21 = null;
/* 099 */     scan_colInstance22 = null;
/* 100 */     scan_colInstance23 = null;
/* 101 */     scan_colInstance24 = null;
/* 102 */     scan_colInstance25 = null;
/* 103 */     scan_colInstance26 = null;
/* 104 */     scan_colInstance27 = null;
/* 105 */     scan_colInstance28 = null;
/* 106 */
/* 107 */   }
/* 108 */
/* 109 */   private void scan_nextBatch() throws java.io.IOException {
/* 110 */     long getBatchStart = System.nanoTime();
/* 111 */     if (scan_input.hasNext()) {
/* 112 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 113 */       scan_numOutputRows.add(scan_batch.numRows());
/* 114 */       scan_batchIdx = 0;
/* 115 */       scan_colInstance0 = scan_batch.column(0);
/* 116 */       scan_colInstance1 = scan_batch.column(1);
/* 117 */       scan_colInstance2 = scan_batch.column(2);
/* 118 */       scan_colInstance3 = scan_batch.column(3);
/* 119 */       scan_colInstance4 = scan_batch.column(4);
/* 120 */       scan_colInstance5 = scan_batch.column(5);
/* 121 */       scan_colInstance6 = scan_batch.column(6);
/* 122 */       scan_colInstance7 = scan_batch.column(7);
/* 123 */       scan_colInstance8 = scan_batch.column(8);
/* 124 */       scan_colInstance9 = scan_batch.column(9);
/* 125 */       scan_colInstance10 = scan_batch.column(10);
/* 126 */       scan_colInstance11 = scan_batch.column(11);
/* 127 */       scan_colInstance12 = scan_batch.column(12);
/* 128 */       scan_colInstance13 = scan_batch.column(13);
/* 129 */       scan_colInstance14 = scan_batch.column(14);
/* 130 */       scan_colInstance15 = scan_batch.column(15);
/* 131 */       scan_colInstance16 = scan_batch.column(16);
/* 132 */       scan_colInstance17 = scan_batch.column(17);
/* 133 */       scan_colInstance18 = scan_batch.column(18);
/* 134 */       scan_colInstance19 = scan_batch.column(19);
/* 135 */       scan_colInstance20 = scan_batch.column(20);
/* 136 */       scan_colInstance21 = scan_batch.column(21);
/* 137 */       scan_colInstance22 = scan_batch.column(22);
/* 138 */       scan_colInstance23 = scan_batch.column(23);
/* 139 */       scan_colInstance24 = scan_batch.column(24);
/* 140 */       scan_colInstance25 = scan_batch.column(25);
/* 141 */       scan_colInstance26 = scan_batch.column(26);
/* 142 */       scan_colInstance27 = scan_batch.column(27);
/* 143 */       scan_colInstance28 = scan_batch.column(28);
/* 144 */       scan_colInstance29 = scan_batch.column(29);
/* 145 */       scan_colInstance30 = scan_batch.column(30);
/* 146 */       scan_colInstance31 = scan_batch.column(31);
/* 147 */       scan_colInstance32 = scan_batch.column(32);
/* 148 */       scan_colInstance33 = scan_batch.column(33);
/* 149 */
/* 150 */     }
/* 151 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 152 */   }
/* 153 */
/* 154 */   private void wholestagecodegen_init_1() {
/* 155 */     scan_colInstance29 = null;
/* 156 */     scan_colInstance30 = null;
/* 157 */     scan_colInstance31 = null;
/* 158 */     scan_colInstance32 = null;
/* 159 */     scan_colInstance33 = null;
/* 160 */     scan_result = new UnsafeRow(34);
/* 161 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 162 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 34);
/* 163 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[2];
/* 164 */
/* 165 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 166 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 167 */
/* 168 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 169 */     bhj_result = new UnsafeRow(62);
/* 170 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 384);
/* 171 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 62);
/* 172 */
/* 173 */   }
/* 174 */
/* 175 */   protected void processNext() throws java.io.IOException {
/* 176 */     if (scan_batch == null) {
/* 177 */       scan_nextBatch();
/* 178 */     }
/* 179 */     while (scan_batch != null) {
/* 180 */       int scan_numRows = scan_batch.numRows();
/* 181 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 182 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 183 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 184 */         boolean scan_isNull33 = scan_colInstance33.isNullAt(scan_rowIdx);
/* 185 */         int scan_value33 = scan_isNull33 ? -1 : (scan_colInstance33.getInt(scan_rowIdx));
/* 186 */
/* 187 */         // generate join key for stream side
/* 188 */
/* 189 */         boolean bhj_isNull = scan_isNull33;
/* 190 */         long bhj_value = -1L;
/* 191 */         if (!scan_isNull33) {
/* 192 */           bhj_value = (long) scan_value33;
/* 193 */         }
/* 194 */         // find matches from HashedRelation
/* 195 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 196 */         if (bhj_matched == null) continue;
/* 197 */
/* 198 */         bhj_numOutputRows.add(1);
/* 199 */
/* 200 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 201 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 202 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 203 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 204 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 205 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 206 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 207 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 208 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 209 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 210 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 211 */         int scan_value5 = scan_isNull5 ? -1 : (scan_colInstance5.getInt(scan_rowIdx));
/* 212 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 213 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 214 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 215 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 216 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 217 */         int scan_value8 = scan_isNull8 ? -1 : (scan_colInstance8.getInt(scan_rowIdx));
/* 218 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 219 */         int scan_value9 = scan_isNull9 ? -1 : (scan_colInstance9.getInt(scan_rowIdx));
/* 220 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 221 */         int scan_value10 = scan_isNull10 ? -1 : (scan_colInstance10.getInt(scan_rowIdx));
/* 222 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 223 */         int scan_value11 = scan_isNull11 ? -1 : (scan_colInstance11.getInt(scan_rowIdx));
/* 224 */         boolean scan_isNull12 = scan_colInstance12.isNullAt(scan_rowIdx);
/* 225 */         int scan_value12 = scan_isNull12 ? -1 : (scan_colInstance12.getInt(scan_rowIdx));
/* 226 */         boolean scan_isNull13 = scan_colInstance13.isNullAt(scan_rowIdx);
/* 227 */         int scan_value13 = scan_isNull13 ? -1 : (scan_colInstance13.getInt(scan_rowIdx));
/* 228 */         boolean scan_isNull14 = scan_colInstance14.isNullAt(scan_rowIdx);
/* 229 */         int scan_value14 = scan_isNull14 ? -1 : (scan_colInstance14.getInt(scan_rowIdx));
/* 230 */         boolean scan_isNull15 = scan_colInstance15.isNullAt(scan_rowIdx);
/* 231 */         int scan_value15 = scan_isNull15 ? -1 : (scan_colInstance15.getInt(scan_rowIdx));
/* 232 */         boolean scan_isNull16 = scan_colInstance16.isNullAt(scan_rowIdx);
/* 233 */         int scan_value16 = scan_isNull16 ? -1 : (scan_colInstance16.getInt(scan_rowIdx));
/* 234 */         boolean scan_isNull17 = scan_colInstance17.isNullAt(scan_rowIdx);
/* 235 */         int scan_value17 = scan_isNull17 ? -1 : (scan_colInstance17.getInt(scan_rowIdx));
/* 236 */         boolean scan_isNull18 = scan_colInstance18.isNullAt(scan_rowIdx);
/* 237 */         double scan_value18 = scan_isNull18 ? -1.0 : (scan_colInstance18.getDouble(scan_rowIdx));
/* 238 */         boolean scan_isNull19 = scan_colInstance19.isNullAt(scan_rowIdx);
/* 239 */         double scan_value19 = scan_isNull19 ? -1.0 : (scan_colInstance19.getDouble(scan_rowIdx));
/* 240 */         boolean scan_isNull20 = scan_colInstance20.isNullAt(scan_rowIdx);
/* 241 */         double scan_value20 = scan_isNull20 ? -1.0 : (scan_colInstance20.getDouble(scan_rowIdx));
/* 242 */         boolean scan_isNull21 = scan_colInstance21.isNullAt(scan_rowIdx);
/* 243 */         double scan_value21 = scan_isNull21 ? -1.0 : (scan_colInstance21.getDouble(scan_rowIdx));
/* 244 */         boolean scan_isNull22 = scan_colInstance22.isNullAt(scan_rowIdx);
/* 245 */         double scan_value22 = scan_isNull22 ? -1.0 : (scan_colInstance22.getDouble(scan_rowIdx));
/* 246 */         boolean scan_isNull23 = scan_colInstance23.isNullAt(scan_rowIdx);
/* 247 */         double scan_value23 = scan_isNull23 ? -1.0 : (scan_colInstance23.getDouble(scan_rowIdx));
/* 248 */         boolean scan_isNull24 = scan_colInstance24.isNullAt(scan_rowIdx);
/* 249 */         double scan_value24 = scan_isNull24 ? -1.0 : (scan_colInstance24.getDouble(scan_rowIdx));
/* 250 */         boolean scan_isNull25 = scan_colInstance25.isNullAt(scan_rowIdx);
/* 251 */         double scan_value25 = scan_isNull25 ? -1.0 : (scan_colInstance25.getDouble(scan_rowIdx));
/* 252 */         boolean scan_isNull26 = scan_colInstance26.isNullAt(scan_rowIdx);
/* 253 */         double scan_value26 = scan_isNull26 ? -1.0 : (scan_colInstance26.getDouble(scan_rowIdx));
/* 254 */         boolean scan_isNull27 = scan_colInstance27.isNullAt(scan_rowIdx);
/* 255 */         double scan_value27 = scan_isNull27 ? -1.0 : (scan_colInstance27.getDouble(scan_rowIdx));
/* 256 */         boolean scan_isNull28 = scan_colInstance28.isNullAt(scan_rowIdx);
/* 257 */         double scan_value28 = scan_isNull28 ? -1.0 : (scan_colInstance28.getDouble(scan_rowIdx));
/* 258 */         boolean scan_isNull29 = scan_colInstance29.isNullAt(scan_rowIdx);
/* 259 */         double scan_value29 = scan_isNull29 ? -1.0 : (scan_colInstance29.getDouble(scan_rowIdx));
/* 260 */         boolean scan_isNull30 = scan_colInstance30.isNullAt(scan_rowIdx);
/* 261 */         double scan_value30 = scan_isNull30 ? -1.0 : (scan_colInstance30.getDouble(scan_rowIdx));
/* 262 */         boolean scan_isNull31 = scan_colInstance31.isNullAt(scan_rowIdx);
/* 263 */         double scan_value31 = scan_isNull31 ? -1.0 : (scan_colInstance31.getDouble(scan_rowIdx));
/* 264 */         boolean scan_isNull32 = scan_colInstance32.isNullAt(scan_rowIdx);
/* 265 */         double scan_value32 = scan_isNull32 ? -1.0 : (scan_colInstance32.getDouble(scan_rowIdx));
/* 266 */         boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 267 */         int bhj_value2 = bhj_isNull2 ? -1 : (bhj_matched.getInt(0));
/* 268 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 269 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 270 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 271 */         UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 272 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 273 */         int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 274 */         boolean bhj_isNull6 = bhj_matched.isNullAt(4);
/* 275 */         int bhj_value6 = bhj_isNull6 ? -1 : (bhj_matched.getInt(4));
/* 276 */         boolean bhj_isNull7 = bhj_matched.isNullAt(5);
/* 277 */         int bhj_value7 = bhj_isNull7 ? -1 : (bhj_matched.getInt(5));
/* 278 */         boolean bhj_isNull8 = bhj_matched.isNullAt(6);
/* 279 */         int bhj_value8 = bhj_isNull8 ? -1 : (bhj_matched.getInt(6));
/* 280 */         boolean bhj_isNull9 = bhj_matched.isNullAt(7);
/* 281 */         int bhj_value9 = bhj_isNull9 ? -1 : (bhj_matched.getInt(7));
/* 282 */         boolean bhj_isNull10 = bhj_matched.isNullAt(8);
/* 283 */         int bhj_value10 = bhj_isNull10 ? -1 : (bhj_matched.getInt(8));
/* 284 */         boolean bhj_isNull11 = bhj_matched.isNullAt(9);
/* 285 */         int bhj_value11 = bhj_isNull11 ? -1 : (bhj_matched.getInt(9));
/* 286 */         boolean bhj_isNull12 = bhj_matched.isNullAt(10);
/* 287 */         int bhj_value12 = bhj_isNull12 ? -1 : (bhj_matched.getInt(10));
/* 288 */         boolean bhj_isNull13 = bhj_matched.isNullAt(11);
/* 289 */         int bhj_value13 = bhj_isNull13 ? -1 : (bhj_matched.getInt(11));
/* 290 */         boolean bhj_isNull14 = bhj_matched.isNullAt(12);
/* 291 */         int bhj_value14 = bhj_isNull14 ? -1 : (bhj_matched.getInt(12));
/* 292 */         boolean bhj_isNull15 = bhj_matched.isNullAt(13);
/* 293 */         int bhj_value15 = bhj_isNull15 ? -1 : (bhj_matched.getInt(13));
/* 294 */         boolean bhj_isNull16 = bhj_matched.isNullAt(14);
/* 295 */         UTF8String bhj_value16 = bhj_isNull16 ? null : (bhj_matched.getUTF8String(14));
/* 296 */         boolean bhj_isNull17 = bhj_matched.isNullAt(15);
/* 297 */         UTF8String bhj_value17 = bhj_isNull17 ? null : (bhj_matched.getUTF8String(15));
/* 298 */         boolean bhj_isNull18 = bhj_matched.isNullAt(16);
/* 299 */         UTF8String bhj_value18 = bhj_isNull18 ? null : (bhj_matched.getUTF8String(16));
/* 300 */         boolean bhj_isNull19 = bhj_matched.isNullAt(17);
/* 301 */         UTF8String bhj_value19 = bhj_isNull19 ? null : (bhj_matched.getUTF8String(17));
/* 302 */         boolean bhj_isNull20 = bhj_matched.isNullAt(18);
/* 303 */         UTF8String bhj_value20 = bhj_isNull20 ? null : (bhj_matched.getUTF8String(18));
/* 304 */         boolean bhj_isNull21 = bhj_matched.isNullAt(19);
/* 305 */         int bhj_value21 = bhj_isNull21 ? -1 : (bhj_matched.getInt(19));
/* 306 */         boolean bhj_isNull22 = bhj_matched.isNullAt(20);
/* 307 */         int bhj_value22 = bhj_isNull22 ? -1 : (bhj_matched.getInt(20));
/* 308 */         boolean bhj_isNull23 = bhj_matched.isNullAt(21);
/* 309 */         int bhj_value23 = bhj_isNull23 ? -1 : (bhj_matched.getInt(21));
/* 310 */         boolean bhj_isNull24 = bhj_matched.isNullAt(22);
/* 311 */         int bhj_value24 = bhj_isNull24 ? -1 : (bhj_matched.getInt(22));
/* 312 */         boolean bhj_isNull25 = bhj_matched.isNullAt(23);
/* 313 */         UTF8String bhj_value25 = bhj_isNull25 ? null : (bhj_matched.getUTF8String(23));
/* 314 */         boolean bhj_isNull26 = bhj_matched.isNullAt(24);
/* 315 */         UTF8String bhj_value26 = bhj_isNull26 ? null : (bhj_matched.getUTF8String(24));
/* 316 */         boolean bhj_isNull27 = bhj_matched.isNullAt(25);
/* 317 */         UTF8String bhj_value27 = bhj_isNull27 ? null : (bhj_matched.getUTF8String(25));
/* 318 */         boolean bhj_isNull28 = bhj_matched.isNullAt(26);
/* 319 */         UTF8String bhj_value28 = bhj_isNull28 ? null : (bhj_matched.getUTF8String(26));
/* 320 */         boolean bhj_isNull29 = bhj_matched.isNullAt(27);
/* 321 */         UTF8String bhj_value29 = bhj_isNull29 ? null : (bhj_matched.getUTF8String(27));
/* 322 */         bhj_holder.reset();
/* 323 */
/* 324 */         bhj_rowWriter.zeroOutNullBytes();
/* 325 */
/* 326 */         if (scan_isNull) {
/* 327 */           bhj_rowWriter.setNullAt(0);
/* 328 */         } else {
/* 329 */           bhj_rowWriter.write(0, scan_value);
/* 330 */         }
/* 331 */
/* 332 */         if (scan_isNull1) {
/* 333 */           bhj_rowWriter.setNullAt(1);
/* 334 */         } else {
/* 335 */           bhj_rowWriter.write(1, scan_value1);
/* 336 */         }
/* 337 */
/* 338 */         if (scan_isNull2) {
/* 339 */           bhj_rowWriter.setNullAt(2);
/* 340 */         } else {
/* 341 */           bhj_rowWriter.write(2, scan_value2);
/* 342 */         }
/* 343 */
/* 344 */         if (scan_isNull3) {
/* 345 */           bhj_rowWriter.setNullAt(3);
/* 346 */         } else {
/* 347 */           bhj_rowWriter.write(3, scan_value3);
/* 348 */         }
/* 349 */
/* 350 */         if (scan_isNull4) {
/* 351 */           bhj_rowWriter.setNullAt(4);
/* 352 */         } else {
/* 353 */           bhj_rowWriter.write(4, scan_value4);
/* 354 */         }
/* 355 */
/* 356 */         if (scan_isNull5) {
/* 357 */           bhj_rowWriter.setNullAt(5);
/* 358 */         } else {
/* 359 */           bhj_rowWriter.write(5, scan_value5);
/* 360 */         }
/* 361 */
/* 362 */         if (scan_isNull6) {
/* 363 */           bhj_rowWriter.setNullAt(6);
/* 364 */         } else {
/* 365 */           bhj_rowWriter.write(6, scan_value6);
/* 366 */         }
/* 367 */
/* 368 */         if (scan_isNull7) {
/* 369 */           bhj_rowWriter.setNullAt(7);
/* 370 */         } else {
/* 371 */           bhj_rowWriter.write(7, scan_value7);
/* 372 */         }
/* 373 */
/* 374 */         if (scan_isNull8) {
/* 375 */           bhj_rowWriter.setNullAt(8);
/* 376 */         } else {
/* 377 */           bhj_rowWriter.write(8, scan_value8);
/* 378 */         }
/* 379 */
/* 380 */         if (scan_isNull9) {
/* 381 */           bhj_rowWriter.setNullAt(9);
/* 382 */         } else {
/* 383 */           bhj_rowWriter.write(9, scan_value9);
/* 384 */         }
/* 385 */
/* 386 */         if (scan_isNull10) {
/* 387 */           bhj_rowWriter.setNullAt(10);
/* 388 */         } else {
/* 389 */           bhj_rowWriter.write(10, scan_value10);
/* 390 */         }
/* 391 */
/* 392 */         if (scan_isNull11) {
/* 393 */           bhj_rowWriter.setNullAt(11);
/* 394 */         } else {
/* 395 */           bhj_rowWriter.write(11, scan_value11);
/* 396 */         }
/* 397 */
/* 398 */         if (scan_isNull12) {
/* 399 */           bhj_rowWriter.setNullAt(12);
/* 400 */         } else {
/* 401 */           bhj_rowWriter.write(12, scan_value12);
/* 402 */         }
/* 403 */
/* 404 */         if (scan_isNull13) {
/* 405 */           bhj_rowWriter.setNullAt(13);
/* 406 */         } else {
/* 407 */           bhj_rowWriter.write(13, scan_value13);
/* 408 */         }
/* 409 */
/* 410 */         if (scan_isNull14) {
/* 411 */           bhj_rowWriter.setNullAt(14);
/* 412 */         } else {
/* 413 */           bhj_rowWriter.write(14, scan_value14);
/* 414 */         }
/* 415 */
/* 416 */         if (scan_isNull15) {
/* 417 */           bhj_rowWriter.setNullAt(15);
/* 418 */         } else {
/* 419 */           bhj_rowWriter.write(15, scan_value15);
/* 420 */         }
/* 421 */
/* 422 */         if (scan_isNull16) {
/* 423 */           bhj_rowWriter.setNullAt(16);
/* 424 */         } else {
/* 425 */           bhj_rowWriter.write(16, scan_value16);
/* 426 */         }
/* 427 */
/* 428 */         if (scan_isNull17) {
/* 429 */           bhj_rowWriter.setNullAt(17);
/* 430 */         } else {
/* 431 */           bhj_rowWriter.write(17, scan_value17);
/* 432 */         }
/* 433 */
/* 434 */         if (scan_isNull18) {
/* 435 */           bhj_rowWriter.setNullAt(18);
/* 436 */         } else {
/* 437 */           bhj_rowWriter.write(18, scan_value18);
/* 438 */         }
/* 439 */
/* 440 */         if (scan_isNull19) {
/* 441 */           bhj_rowWriter.setNullAt(19);
/* 442 */         } else {
/* 443 */           bhj_rowWriter.write(19, scan_value19);
/* 444 */         }
/* 445 */
/* 446 */         if (scan_isNull20) {
/* 447 */           bhj_rowWriter.setNullAt(20);
/* 448 */         } else {
/* 449 */           bhj_rowWriter.write(20, scan_value20);
/* 450 */         }
/* 451 */
/* 452 */         if (scan_isNull21) {
/* 453 */           bhj_rowWriter.setNullAt(21);
/* 454 */         } else {
/* 455 */           bhj_rowWriter.write(21, scan_value21);
/* 456 */         }
/* 457 */
/* 458 */         if (scan_isNull22) {
/* 459 */           bhj_rowWriter.setNullAt(22);
/* 460 */         } else {
/* 461 */           bhj_rowWriter.write(22, scan_value22);
/* 462 */         }
/* 463 */
/* 464 */         if (scan_isNull23) {
/* 465 */           bhj_rowWriter.setNullAt(23);
/* 466 */         } else {
/* 467 */           bhj_rowWriter.write(23, scan_value23);
/* 468 */         }
/* 469 */
/* 470 */         if (scan_isNull24) {
/* 471 */           bhj_rowWriter.setNullAt(24);
/* 472 */         } else {
/* 473 */           bhj_rowWriter.write(24, scan_value24);
/* 474 */         }
/* 475 */
/* 476 */         if (scan_isNull25) {
/* 477 */           bhj_rowWriter.setNullAt(25);
/* 478 */         } else {
/* 479 */           bhj_rowWriter.write(25, scan_value25);
/* 480 */         }
/* 481 */
/* 482 */         if (scan_isNull26) {
/* 483 */           bhj_rowWriter.setNullAt(26);
/* 484 */         } else {
/* 485 */           bhj_rowWriter.write(26, scan_value26);
/* 486 */         }
/* 487 */
/* 488 */         if (scan_isNull27) {
/* 489 */           bhj_rowWriter.setNullAt(27);
/* 490 */         } else {
/* 491 */           bhj_rowWriter.write(27, scan_value27);
/* 492 */         }
/* 493 */
/* 494 */         if (scan_isNull28) {
/* 495 */           bhj_rowWriter.setNullAt(28);
/* 496 */         } else {
/* 497 */           bhj_rowWriter.write(28, scan_value28);
/* 498 */         }
/* 499 */
/* 500 */         if (scan_isNull29) {
/* 501 */           bhj_rowWriter.setNullAt(29);
/* 502 */         } else {
/* 503 */           bhj_rowWriter.write(29, scan_value29);
/* 504 */         }
/* 505 */
/* 506 */         if (scan_isNull30) {
/* 507 */           bhj_rowWriter.setNullAt(30);
/* 508 */         } else {
/* 509 */           bhj_rowWriter.write(30, scan_value30);
/* 510 */         }
/* 511 */
/* 512 */         if (scan_isNull31) {
/* 513 */           bhj_rowWriter.setNullAt(31);
/* 514 */         } else {
/* 515 */           bhj_rowWriter.write(31, scan_value31);
/* 516 */         }
/* 517 */
/* 518 */         if (scan_isNull32) {
/* 519 */           bhj_rowWriter.setNullAt(32);
/* 520 */         } else {
/* 521 */           bhj_rowWriter.write(32, scan_value32);
/* 522 */         }
/* 523 */
/* 524 */         if (scan_isNull33) {
/* 525 */           bhj_rowWriter.setNullAt(33);
/* 526 */         } else {
/* 527 */           bhj_rowWriter.write(33, scan_value33);
/* 528 */         }
/* 529 */
/* 530 */         if (bhj_isNull2) {
/* 531 */           bhj_rowWriter.setNullAt(34);
/* 532 */         } else {
/* 533 */           bhj_rowWriter.write(34, bhj_value2);
/* 534 */         }
/* 535 */
/* 536 */         if (bhj_isNull3) {
/* 537 */           bhj_rowWriter.setNullAt(35);
/* 538 */         } else {
/* 539 */           bhj_rowWriter.write(35, bhj_value3);
/* 540 */         }
/* 541 */
/* 542 */         if (bhj_isNull4) {
/* 543 */           bhj_rowWriter.setNullAt(36);
/* 544 */         } else {
/* 545 */           bhj_rowWriter.write(36, bhj_value4);
/* 546 */         }
/* 547 */
/* 548 */         if (bhj_isNull5) {
/* 549 */           bhj_rowWriter.setNullAt(37);
/* 550 */         } else {
/* 551 */           bhj_rowWriter.write(37, bhj_value5);
/* 552 */         }
/* 553 */
/* 554 */         if (bhj_isNull6) {
/* 555 */           bhj_rowWriter.setNullAt(38);
/* 556 */         } else {
/* 557 */           bhj_rowWriter.write(38, bhj_value6);
/* 558 */         }
/* 559 */
/* 560 */         if (bhj_isNull7) {
/* 561 */           bhj_rowWriter.setNullAt(39);
/* 562 */         } else {
/* 563 */           bhj_rowWriter.write(39, bhj_value7);
/* 564 */         }
/* 565 */
/* 566 */         if (bhj_isNull8) {
/* 567 */           bhj_rowWriter.setNullAt(40);
/* 568 */         } else {
/* 569 */           bhj_rowWriter.write(40, bhj_value8);
/* 570 */         }
/* 571 */
/* 572 */         if (bhj_isNull9) {
/* 573 */           bhj_rowWriter.setNullAt(41);
/* 574 */         } else {
/* 575 */           bhj_rowWriter.write(41, bhj_value9);
/* 576 */         }
/* 577 */
/* 578 */         if (bhj_isNull10) {
/* 579 */           bhj_rowWriter.setNullAt(42);
/* 580 */         } else {
/* 581 */           bhj_rowWriter.write(42, bhj_value10);
/* 582 */         }
/* 583 */
/* 584 */         if (bhj_isNull11) {
/* 585 */           bhj_rowWriter.setNullAt(43);
/* 586 */         } else {
/* 587 */           bhj_rowWriter.write(43, bhj_value11);
/* 588 */         }
/* 589 */
/* 590 */         if (bhj_isNull12) {
/* 591 */           bhj_rowWriter.setNullAt(44);
/* 592 */         } else {
/* 593 */           bhj_rowWriter.write(44, bhj_value12);
/* 594 */         }
/* 595 */
/* 596 */         if (bhj_isNull13) {
/* 597 */           bhj_rowWriter.setNullAt(45);
/* 598 */         } else {
/* 599 */           bhj_rowWriter.write(45, bhj_value13);
/* 600 */         }
/* 601 */
/* 602 */         if (bhj_isNull14) {
/* 603 */           bhj_rowWriter.setNullAt(46);
/* 604 */         } else {
/* 605 */           bhj_rowWriter.write(46, bhj_value14);
/* 606 */         }
/* 607 */
/* 608 */         if (bhj_isNull15) {
/* 609 */           bhj_rowWriter.setNullAt(47);
/* 610 */         } else {
/* 611 */           bhj_rowWriter.write(47, bhj_value15);
/* 612 */         }
/* 613 */
/* 614 */         if (bhj_isNull16) {
/* 615 */           bhj_rowWriter.setNullAt(48);
/* 616 */         } else {
/* 617 */           bhj_rowWriter.write(48, bhj_value16);
/* 618 */         }
/* 619 */
/* 620 */         if (bhj_isNull17) {
/* 621 */           bhj_rowWriter.setNullAt(49);
/* 622 */         } else {
/* 623 */           bhj_rowWriter.write(49, bhj_value17);
/* 624 */         }
/* 625 */
/* 626 */         if (bhj_isNull18) {
/* 627 */           bhj_rowWriter.setNullAt(50);
/* 628 */         } else {
/* 629 */           bhj_rowWriter.write(50, bhj_value18);
/* 630 */         }
/* 631 */
/* 632 */         if (bhj_isNull19) {
/* 633 */           bhj_rowWriter.setNullAt(51);
/* 634 */         } else {
/* 635 */           bhj_rowWriter.write(51, bhj_value19);
/* 636 */         }
/* 637 */
/* 638 */         if (bhj_isNull20) {
/* 639 */           bhj_rowWriter.setNullAt(52);
/* 640 */         } else {
/* 641 */           bhj_rowWriter.write(52, bhj_value20);
/* 642 */         }
/* 643 */
/* 644 */         if (bhj_isNull21) {
/* 645 */           bhj_rowWriter.setNullAt(53);
/* 646 */         } else {
/* 647 */           bhj_rowWriter.write(53, bhj_value21);
/* 648 */         }
/* 649 */
/* 650 */         if (bhj_isNull22) {
/* 651 */           bhj_rowWriter.setNullAt(54);
/* 652 */         } else {
/* 653 */           bhj_rowWriter.write(54, bhj_value22);
/* 654 */         }
/* 655 */
/* 656 */         if (bhj_isNull23) {
/* 657 */           bhj_rowWriter.setNullAt(55);
/* 658 */         } else {
/* 659 */           bhj_rowWriter.write(55, bhj_value23);
/* 660 */         }
/* 661 */
/* 662 */         if (bhj_isNull24) {
/* 663 */           bhj_rowWriter.setNullAt(56);
/* 664 */         } else {
/* 665 */           bhj_rowWriter.write(56, bhj_value24);
/* 666 */         }
/* 667 */
/* 668 */         if (bhj_isNull25) {
/* 669 */           bhj_rowWriter.setNullAt(57);
/* 670 */         } else {
/* 671 */           bhj_rowWriter.write(57, bhj_value25);
/* 672 */         }
/* 673 */
/* 674 */         if (bhj_isNull26) {
/* 675 */           bhj_rowWriter.setNullAt(58);
/* 676 */         } else {
/* 677 */           bhj_rowWriter.write(58, bhj_value26);
/* 678 */         }
/* 679 */
/* 680 */         if (bhj_isNull27) {
/* 681 */           bhj_rowWriter.setNullAt(59);
/* 682 */         } else {
/* 683 */           bhj_rowWriter.write(59, bhj_value27);
/* 684 */         }
/* 685 */
/* 686 */         if (bhj_isNull28) {
/* 687 */           bhj_rowWriter.setNullAt(60);
/* 688 */         } else {
/* 689 */           bhj_rowWriter.write(60, bhj_value28);
/* 690 */         }
/* 691 */
/* 692 */         if (bhj_isNull29) {
/* 693 */           bhj_rowWriter.setNullAt(61);
/* 694 */         } else {
/* 695 */           bhj_rowWriter.write(61, bhj_value29);
/* 696 */         }
/* 697 */         bhj_result.setTotalSize(bhj_holder.totalSize());
/* 698 */         append(bhj_result);
/* 699 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 700 */       }
/* 701 */       scan_batchIdx = scan_numRows;
/* 702 */       scan_batch = null;
/* 703 */       scan_nextBatch();
/* 704 */     }
/* 705 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 706 */     scan_scanTime1 = 0;
/* 707 */   }
/* 708 */ }
