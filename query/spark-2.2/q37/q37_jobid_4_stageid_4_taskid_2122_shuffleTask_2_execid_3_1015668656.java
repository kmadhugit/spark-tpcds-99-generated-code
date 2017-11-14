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
/* 017 */   private UnsafeRow scan_result;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 021 */   private UnsafeRow filter_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 028 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 030 */   private UnsafeRow bhj_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 033 */   private UnsafeRow project_result1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 036 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 037 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 039 */   private UnsafeRow bhj_result1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 042 */   private UnsafeRow project_result2;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 045 */
/* 046 */   public GeneratedIterator(Object[] references) {
/* 047 */     this.references = references;
/* 048 */   }
/* 049 */
/* 050 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 051 */     partitionIndex = index;
/* 052 */     this.inputs = inputs;
/* 053 */     wholestagecodegen_init_0();
/* 054 */     wholestagecodegen_init_1();
/* 055 */     wholestagecodegen_init_2();
/* 056 */
/* 057 */   }
/* 058 */
/* 059 */   private void wholestagecodegen_init_0() {
/* 060 */     scan_input = inputs[0];
/* 061 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 062 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 063 */     scan_scanTime1 = 0;
/* 064 */     scan_batch = null;
/* 065 */     scan_batchIdx = 0;
/* 066 */     scan_colInstance0 = null;
/* 067 */     scan_colInstance1 = null;
/* 068 */     scan_colInstance2 = null;
/* 069 */     scan_result = new UnsafeRow(3);
/* 070 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 071 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 072 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 073 */     filter_result = new UnsafeRow(3);
/* 074 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 075 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 076 */     project_result = new UnsafeRow(2);
/* 077 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   private void scan_nextBatch() throws java.io.IOException {
/* 082 */     long getBatchStart = System.nanoTime();
/* 083 */     if (scan_input.hasNext()) {
/* 084 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 085 */       scan_numOutputRows.add(scan_batch.numRows());
/* 086 */       scan_batchIdx = 0;
/* 087 */       scan_colInstance0 = scan_batch.column(0);
/* 088 */       scan_colInstance1 = scan_batch.column(1);
/* 089 */       scan_colInstance2 = scan_batch.column(2);
/* 090 */
/* 091 */     }
/* 092 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 093 */   }
/* 094 */
/* 095 */   private void wholestagecodegen_init_2() {
/* 096 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 097 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 098 */
/* 099 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 100 */     bhj_result1 = new UnsafeRow(6);
/* 101 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 102 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 103 */     project_result2 = new UnsafeRow(4);
/* 104 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 105 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 4);
/* 106 */
/* 107 */   }
/* 108 */
/* 109 */   private void wholestagecodegen_init_1() {
/* 110 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 111 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 112 */
/* 113 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 114 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 115 */
/* 116 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 117 */     bhj_result = new UnsafeRow(6);
/* 118 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 119 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 120 */     project_result1 = new UnsafeRow(5);
/* 121 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 122 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 123 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 124 */
/* 125 */   }
/* 126 */
/* 127 */   protected void processNext() throws java.io.IOException {
/* 128 */     if (scan_batch == null) {
/* 129 */       scan_nextBatch();
/* 130 */     }
/* 131 */     while (scan_batch != null) {
/* 132 */       int scan_numRows = scan_batch.numRows();
/* 133 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 134 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 135 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 136 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 137 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 138 */
/* 139 */         if (!(!(scan_isNull1))) continue;
/* 140 */
/* 141 */         boolean filter_isNull2 = false;
/* 142 */
/* 143 */         boolean filter_value2 = false;
/* 144 */         filter_value2 = scan_value1 >= 100;
/* 145 */         if (!filter_value2) continue;
/* 146 */         boolean filter_isNull5 = false;
/* 147 */
/* 148 */         boolean filter_value5 = false;
/* 149 */         filter_value5 = scan_value1 <= 500;
/* 150 */         if (!filter_value5) continue;
/* 151 */
/* 152 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 153 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 154 */
/* 155 */         if (!(!(scan_isNull))) continue;
/* 156 */
/* 157 */         filter_numOutputRows.add(1);
/* 158 */
/* 159 */         // generate join key for stream side
/* 160 */
/* 161 */         boolean bhj_isNull = false;
/* 162 */         long bhj_value = -1L;
/* 163 */         if (!false) {
/* 164 */           bhj_value = (long) scan_value;
/* 165 */         }
/* 166 */         // find matches from HashedRelation
/* 167 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 168 */         if (bhj_matched == null) continue;
/* 169 */
/* 170 */         bhj_numOutputRows.add(1);
/* 171 */
/* 172 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 173 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 174 */
/* 175 */         // generate join key for stream side
/* 176 */
/* 177 */         boolean bhj_isNull12 = scan_isNull2;
/* 178 */         long bhj_value12 = -1L;
/* 179 */         if (!scan_isNull2) {
/* 180 */           bhj_value12 = (long) scan_value2;
/* 181 */         }
/* 182 */         // find matches from HashedRelation
/* 183 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 184 */         if (bhj_matched1 == null) continue;
/* 185 */
/* 186 */         bhj_numOutputRows1.add(1);
/* 187 */
/* 188 */         boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 189 */         int bhj_value2 = bhj_isNull2 ? -1 : (bhj_matched.getInt(0));
/* 190 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 191 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 192 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 193 */         UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 194 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 195 */         double bhj_value5 = bhj_isNull5 ? -1.0 : (bhj_matched.getDouble(3));
/* 196 */         project_holder2.reset();
/* 197 */
/* 198 */         project_rowWriter2.zeroOutNullBytes();
/* 199 */
/* 200 */         if (bhj_isNull2) {
/* 201 */           project_rowWriter2.setNullAt(0);
/* 202 */         } else {
/* 203 */           project_rowWriter2.write(0, bhj_value2);
/* 204 */         }
/* 205 */
/* 206 */         if (bhj_isNull3) {
/* 207 */           project_rowWriter2.setNullAt(1);
/* 208 */         } else {
/* 209 */           project_rowWriter2.write(1, bhj_value3);
/* 210 */         }
/* 211 */
/* 212 */         if (bhj_isNull4) {
/* 213 */           project_rowWriter2.setNullAt(2);
/* 214 */         } else {
/* 215 */           project_rowWriter2.write(2, bhj_value4);
/* 216 */         }
/* 217 */
/* 218 */         if (bhj_isNull5) {
/* 219 */           project_rowWriter2.setNullAt(3);
/* 220 */         } else {
/* 221 */           project_rowWriter2.write(3, bhj_value5);
/* 222 */         }
/* 223 */         project_result2.setTotalSize(project_holder2.totalSize());
/* 224 */         append(project_result2);
/* 225 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 226 */       }
/* 227 */       scan_batchIdx = scan_numRows;
/* 228 */       scan_batch = null;
/* 229 */       scan_nextBatch();
/* 230 */     }
/* 231 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 232 */     scan_scanTime1 = 0;
/* 233 */   }
/* 234 */ }
